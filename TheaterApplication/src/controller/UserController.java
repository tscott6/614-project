package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import view.CancelView;
import view.MovieViewer;
import view.UserDashboard;
import model.Ticket;
import model.User;

public class UserController {

	protected Application application;
	protected UserDashboard userDashboard = null;
	protected CancelController myCancelController = null;
	protected CancelView myCancelView = null;
	protected User theUser = null;
//	protected boolean userIsReg;

	public void setApplication(Application application) {
		this.application = application;
	}

	public void setUserDashboard(UserDashboard userDashboard) {
		this.userDashboard = userDashboard;
	}

	public CancelController getMyCancelController() {
		return this.myCancelController;
	}

	public void setMyCancelController(CancelController myCancelController) {
		this.myCancelController = myCancelController;
	}

	public CancelView getMyCancelView() {
		return this.myCancelView;
	}

	public void setMyCancelView(CancelView myCancelView) {
		this.myCancelView = myCancelView;
	}

	public User getTheUser() {
		return this.theUser;
	}

	public void setTheUser(User theUser) {
		this.theUser = theUser;
	}

	public ActionListener getUserDashboardListener() {
		return this.userDashboardListener;
	}

	public void setUserDashboardListener(ActionListener userDashboardListener) {
		this.userDashboardListener = userDashboardListener;
	}

	public UserController() {
//		this.application = app;
		theUser = new User();
		// createUserDashboard();
	}

	public Application getApplication() {
		return application;
	}

	public void changeApplicationView(JPanel oldView, JPanel newView) {
		this.getApplication().changeApplicationView(oldView, newView);
	}

	public UserController currentUserController() {
		return this;
	}
	
	public UserDashboard getUserDashView() {
		return userDashboard;
	}

	public JPanel getUserDashboardView() {
		return userDashboard.getUserDashboardPanel();
	}

	public void revertToApplicationView(JPanel currentPanel) {
		this.application.getApplicationView().remove(currentPanel);
		this.application.getApplicationView().add(this.application.getApplicationView().getAppPanel());
		this.application.getApplicationView().revalidate();
		this.application.getApplicationView().validate();
		this.application.getApplicationView().repaint();
	}

	/* User DashBoard methods */
	public void createUserDashboard() {
		this.userDashboard = new UserDashboard();
	}

	public JPanel changeToUserDashboard() {
		return this.userDashboard.getUserDashboardPanel();
	}

	public UserDashboard getUserDashboard() {
		return userDashboard;
	}

	public void setUserDashboardButtonListener() {
		this.userDashboard.getFindMovieButton().addActionListener(userDashboardListener);
		this.userDashboard.getCancelBookingButton().addActionListener(userDashboardListener);
		this.userDashboard.getExitButton().addActionListener(userDashboardListener);
	}

	ActionListener userDashboardListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(getUserDashboard().getCancelBookingButton())) {
				myCancelController = new CancelController(createCancelView(), currentUserController());
				
				System.out.println(currentUserController().getTheUser().getIsRegUser()); // THIS IS WHERE ITS FALSE WE NEED TO SEE TRUE
				
				changeApplicationView(changeToUserDashboard(), ShowCancelView());
				System.out.println("Dashboard cancel booking button clicked");
			} else if (e.getSource().equals(getUserDashboard().getExitButton())) {
				System.out.println("Dashboard exit button clicked");
				revertToApplicationView(getUserDashboard().getUserDashboardPanel());
			}
			else if  (e.getSource().equals(getUserDashboard().getFindMovieButton()))
			{ 
				System.out.println("Dashboard find movie button clicked");
				MovieViewer movieViewer = new MovieViewer();
				BookingController bookingCntrl = new BookingController(movieViewer);
				bookingCntrl.setUserCntrl(currentUserController());
				movieViewer.addMovieActionListeners(bookingCntrl);
			}
		}
	};

	public CancelView createCancelView() {
		return this.myCancelView = new CancelView();
	}

	public JPanel ShowCancelView() {
		return this.myCancelView.getCancelPanel();
	}

//	public Ticket getUserTicket(int ticketNumber) {
//		for (Ticket ticket : theUser.getUserTickets()) {
//			if (ticket.getTicketId() == ticketNumber)
//				return ticket;
//		}
//		return null;
//	}
//
//	public Boolean deleteTicket(Ticket ticket) {
//		return theUser.getUserTickets().remove(ticket);
//	}

	public void setAppViewVisibility(boolean b) {
		application.getApplicationView().setVisible(b);
		
	}
	
//	public void setUserIsReg(boolean b) {
//		userIsReg = b;
//	}
//	
//	public boolean isUserReg() {
//		return userIsReg;
//	}
}



