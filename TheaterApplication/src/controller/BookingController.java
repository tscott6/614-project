package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import model.Movie;
import model.MovieCatalog;
import model.Payment;
import model.Seat;
import model.Showing;
import model.Theater;
import model.Ticket;
import repository.SeatRepository;
import repository.ShowingRepository;
import repository.TicketRepository;
import view.MovieViewer;
import view.PaymentViewOrdinary;
import view.ShowingView;

public class BookingController implements ActionListener{
	private MovieViewer movieViewer;
	private UserController userCntrl;
	private HashMap<Integer, Showing> showingsMap;
	private ShowingView showingViewer;
	private String movieName;
	private ArrayList <Seat> seats;
	
	
	public BookingController(MovieViewer movieViewer) {
		this.movieViewer = movieViewer;
		setMovieDropDwn(new MovieCatalog().getMovies());
		movieViewCloseOp();
	}
	
	public void setMovieDropDwn(ArrayList <Movie> movies) {
    	for (Movie movie: movies) {
    		movieViewer.getMovieDropDwn().addItem(movie.toString());
    	}
    }
	
	public void setShowingDropDwn(ArrayList <String> showingStrings) {
    	for (String string: showingStrings) {
    		showingViewer.getShowingDropDwn().addItem(string);
    	}
    }
	
	public void setSeatsDropDwn(ArrayList <String> showingStrings) {
		showingViewer.getAvailableSeats().removeAllItems();
		for (String string: showingStrings) {
			showingViewer.getAvailableSeats().addItem(string);
    	}
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(movieViewer.getBackButton())) {
			movieViewer.setVisible(false);
			movieViewer.dispose();
			userCntrl.setAppViewVisibility(true);
		} 
		else if(e.getSource().equals(movieViewer.getSeeViewTimesButton())) {
			String movieString = (String) movieViewer.getMovieDropDwn().getSelectedItem();
			movieName = movieString.split(",")[0]; 
			showingViewer = new ShowingView(movieName); 
			showingViewer.addShowingActionListeners(this);
			showingViewCloseOp();
			movieViewer.setVisible(false);
			System.out.println("Movie that user selected: " + movieString);
			setShowingDropDwn(loadShowings(movieName));
		}
		else if(e.getSource().equals(showingViewer.getSeeSeatsButton())) {
			System.out.println("See seats button clicked");
			String showingIdS = ((String)showingViewer.getShowingDropDwn().getSelectedItem()).substring(0,1);
			int showingId = Integer.parseInt(showingIdS);
			SeatRepository repo = new SeatRepository();
			repo.initializeConnection();
			seats = repo.getAvailableSeats(showingId);
			ArrayList <String> seatStrings = new ArrayList<String>();
			
			for (Seat seat: seats) {
				seatStrings.add(seat.toString());
				
			}
			setSeatsDropDwn(seatStrings);
		}
		
		else if(e.getSource().equals(showingViewer.getSelectSeatBtn())) {
			
			String seatNumberC = ((String) showingViewer.getAvailableSeats().getSelectedItem()).substring(0, 1);
			int seatNumber = Integer.parseInt(seatNumberC);
			System.out.println("Seat Number Selected is: " + seatNumber);
			String showingIdS = ((String)showingViewer.getShowingDropDwn().getSelectedItem()).substring(0,1);
			int showingId = Integer.parseInt(showingIdS);
			showingViewer.setVisible(false);
			TicketRepository repo = new TicketRepository();
			repo.initializeConnection();
			ShowingRepository srepo = new ShowingRepository();
			srepo.initializeConnection();

			int newTicketID = repo.getHighestID() + 1;
			Showing showing = showingsMap.get(showingId);
			Movie movie = srepo.getMovie(movieName);
			int fromFront = 0;
			for (Seat seat: seats) {
				if (seat.getSeatNumber() == seatNumber) {
					fromFront = seatNumber;
				}
			}
			
			Ticket newTicket = new Ticket(newTicketID, movie, showing.getTheater(), showing.getLocation(), 15.32, seatNumber,
					fromFront, showing.getDate(), showing.getTime(), "Active");
			System.out.println(movie);
			PaymentViewOrdinary viewOrdinary = new PaymentViewOrdinary(15.32);
			PaymentControllerOrdinary paymentOrdinary = new PaymentControllerOrdinary(new Payment(), viewOrdinary, "Movie", newTicket, 15.32, userCntrl);
			showingViewer.setVisible(false);
			showingViewer.dispose();

		}
		
		else if(e.getSource().equals(showingViewer.getBackButton())) {
			movieViewer.setVisible(true);
			showingViewer.setVisible(false);
			showingViewer.dispose();
		}
	}
	
	
	public ArrayList<String> loadShowings(String movieName) {
		ShowingRepository repo = new ShowingRepository();
		repo.initializeConnection();
		//TODO: watch out
		ArrayList<Showing> showings = new ArrayList<>(repo.getShowingsUser(movieName));
		ArrayList<String> showingStrings = new ArrayList<String>();
		showingsMap = new HashMap<Integer, Showing>();
		for (Showing showing: showings) {
			showingsMap.put(showing.getShowingNum(), (showing));
			showingStrings.add(showing.toString());
		}
		return showingStrings;
	}
	
	public void movieViewCloseOp() {
	    movieViewer.addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent e) {
	            System.out.println("Movie View quit without back button");
				userCntrl.setAppViewVisibility(true);
	        }
	    });
	}
	
	public void showingViewCloseOp() {
	    showingViewer.addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent e) {
	            System.out.println("Showing View quit without back button");
				movieViewer.setVisible(true);
	        }
	    });
	}
	
	public void setUserCntrl(UserController userCntrl) {
		this.userCntrl = userCntrl;
		this.userCntrl.setAppViewVisibility(false);
	}
}
