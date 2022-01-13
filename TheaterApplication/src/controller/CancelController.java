package controller;

// import java.time.temporal;
import static java.time.temporal.ChronoUnit.HOURS;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
// import java.util.ArrayList;

import javax.swing.JPanel;

import model.*;
import repository.*;
import view.*;

public class CancelController {

    protected UserController userController = null;
    protected CancelView myCancelView = null;
    protected TicketRepository ticketRepository;
    protected CancellationRepository cancellationRepository;
    protected SeatRepository seatRepository;

//    private String DBURL = "jdbc:mysql://localhost:3306/moviebookingdb";
//    private String USERNAME = "root";
//    private String PASSWORD = TheaterApp.getServerPassword();

    public CancelController(CancelView cancelView, UserController userController) {
        this.myCancelView = cancelView;
        this.userController = userController;
        this.myCancelView.addActionListenerCancelButton(new CancelTicket());
        this.myCancelView.addActionListenerBackButton(new CancelTicket());
        System.out.println("In CancelController Constructor");
    }

    class CancelTicket implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(getCancelView().getCancelButton())) {
                System.out.println("CancelTicket button clicked");
                getCancelView().setConfimationLabeText(CancelTicket(getCancelView().getTicketNumberText()));
            } else if (e.getSource().equals(getCancelView().getBackButton())) {
                System.out.println("Back button clicked");
                getCurrentUserController().changeApplicationView(getCancelView().getCancelPanel(),
                        getCurrentUserController().getUserDashView().getUserDashboardPanel());
            }
        }

    }

    private UserController getCurrentUserController() {
        return userController;
    }

    public CancelView getCancelView() {
        return myCancelView;
    }

    public CancelController getCancelController() {
        return this;
    }

    private UserController getUserController() {
        return userController;
    }

    public void changeApplicationViewWrapper(JPanel oldView, JPanel newView) {

        getUserController().changeApplicationView(oldView, newView);
    }

    public JPanel getCancelJPanel() {
        return this.myCancelView.getCancelPanel();
    }

    @SuppressWarnings("unused")
	private String CancelTicket(String ticketNumber) {

        System.out.println("Cancle this ticket now " + ticketNumber);
        String ticketCancelResult = "";
        if (ticketNumber.length() > 0) {
            int myTicketNumber = Integer.parseInt(ticketNumber);

            ticketRepository = new TicketRepository();
            ticketRepository.initializeConnection();

            cancellationRepository = new CancellationRepository();
            cancellationRepository.initializeConnection();

            seatRepository = new SeatRepository();
            seatRepository.initializeConnection();

            Ticket foundTicket = ticketRepository.getTickets(myTicketNumber);

            if (foundTicket != null) {
                System.out.println("Ticket found");

                String str = foundTicket.getShowingDate() + " " + foundTicket.getShowingTime();
                System.out.println(str);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime ticketDateTime = LocalDateTime.parse(str, formatter);
                LocalDateTime currentDateTime = LocalDateTime.now();
                DateTimeFormatter Dateformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String myDateString = currentDateTime.format(Dateformatter);
                long hours = HOURS.between(currentDateTime, ticketDateTime);
                if (hours >= 72) {
                	
                	double userCredit;
                	if (ticketRepository.isRegUser(foundTicket.getTicketId())) {
                		userCredit = foundTicket.getPrice();
                	}
                	else {
                		userCredit = foundTicket.getPrice() * 0.85;
                	}
                	
                    cancellationRepository.createCancellation(foundTicket.getTicketId(),
                            myDateString,
                            userCredit);
                    seatRepository.changeSeatStatus(foundTicket.getTheSeatNumber(), foundTicket.getRowFromFront(),
                            foundTicket.getLocation(), foundTicket.getTheaterID(), true);

                    ticketRepository.setTicketStatus(foundTicket.getTicketId(), "Cancel");

                    ticketCancelResult = "Ticket cancellation successfull";

                } else {
                    ticketCancelResult = "Tickets time is less than 72 hours";
                }
            } else {
            	ticketCancelResult = "No ticket found";
            }
            
        }
        return ticketCancelResult;
    }

}