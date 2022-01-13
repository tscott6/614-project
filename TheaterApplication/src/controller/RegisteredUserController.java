package controller;

import java.awt.event.*;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JPanel;

import model.RegisteredUser;
import repository.UserRepository;
import view.*;
import static java.time.temporal.ChronoUnit.DAYS;

public class RegisteredUserController extends UserController {
	private LoginView loginView;
	private RegistrationView regView;
	private PayAnnualFeeView payAnnualFeeView = null;
	private PayAnnualFeeController  myPayAnnualFeeController = null;
	private MovieNewsController movieNewsController;
	private UserRepository userRepo;
	private RegisteredUser registeredUser;
	
	
	public RegisteredUserController(String viewType)
	{
		
		if(viewType.equals("LOGIN"))
		{
			this.createLoginView();
			this.setLoginViewButtonListener();
			
			setUserRepo(new UserRepository());
			this.userRepo.initializeConnection();
			
			System.out.println("Created login view");
		}
		else if(viewType.equals("REGISTER"))
		{
			this.createRegistrationView();
			this.setRegistrationViewButtonListener();
			
			setUserRepo(new UserRepository());
			this.userRepo.initializeConnection();
			
			System.out.println("Created registration view");
		}
	}
	
	public void setRegisteredUser(RegisteredUser usr) {
		this.registeredUser = usr;
	}
	
	public RegisteredUser getRegisteredUser() {
		return this.registeredUser;
	}
	
	public MovieNewsController getMovieNewsController()
	{
		return movieNewsController;
	}
	
	public void createLoginView()
	{
		this.loginView = new LoginView();
	}
	
	public void createRegistrationView()
	{
		this.regView = new RegistrationView();
	}
	
	public JPanel changeToLoginView()
	{
		return this.loginView.getLoginPanel();
	}
	
	public JPanel changeToRegistrationView()
	{
		return this.regView.getRegPanel();
	}
	
	public JPanel changeToMovieNewsView()
	{
		return getMovieNewsController().getMovieNewsPanel();
	}
	
	public void setLoginViewButtonListener()
	{
		this.loginView.getLoginButton().addActionListener(loginViewListener);
		this.loginView.getBackButton().addActionListener(loginViewListener);
	}
	
	public void setRegistrationViewButtonListener()
	{
		this.regView.getRegButton().addActionListener(registrationViewListener);
		this.regView.getBackButton().addActionListener(registrationViewListener);
	}
	
	public void setRegisteredUserDashboardButtonListener()
	{
		((RegisteredUserDashboard)this.userDashboard).getPayAnnualFeeButton().addActionListener(registeredUserDashboardListener);
		((RegisteredUserDashboard)this.userDashboard).getViewMovieNewsButton().addActionListener(registeredUserDashboardListener);
	}
	
	ActionListener loginViewListener = new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource().equals(getLoginView().getLoginButton()))
			{
				System.out.println("Login button clicked");
				
				try {
					boolean foundUsername = getUserRepo().checkUserEmail(getLoginView().getLoginNameField().getText());
					boolean foundPassword = getUserRepo().checkUserPassword(getLoginView().getLoginIDField().getText());
					
					System.out.println("foundUsername = " + foundUsername);
					System.out.println("foundPassword = " + foundPassword);
					
					if(foundUsername == true && foundPassword == true)
					{
						userDashboard = new RegisteredUserDashboard();
						setUserDashboardButtonListener();
						setRegisteredUserDashboardButtonListener();
						changeApplicationView(changeToLoginView(), changeToUserDashboard());
						try {
							setRegisteredUser(getUserRepo().getRegisteredUser(getLoginView().getLoginNameField().getText()));
							System.out.println(getRegisteredUser().getRegistrationDate());
						} catch (NullPointerException ex) {
							ex.getMessage();
							System.out.println("User email not found");
						}
					}
					else
					{
						getLoginView().getLoginConfirmLabel().setText("Error, user email and/or password incorrect");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(e.getSource().equals(getLoginView().getBackButton()))
			{
				System.out.println("Login back button clicked");
				revertToApplicationView(getLoginView().getLoginPanel());
			}
		}
	};
	
	ActionListener registrationViewListener = new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource().equals(getRegistrationView().getRegButton()))
			{
				System.out.println("Registration button clicked");
				
				try {
					boolean foundUsername = getUserRepo().checkUserEmail(getRegistrationView().getRegNameField().getText());
					String password = getRegistrationView().getRegPasswordField().getText();
					String name = getRegistrationView().getRegNameField().getText();
					String email = getRegistrationView().getRegEmailField().getText();
					String paymentNum = getRegistrationView().getRegBankCardField().getText();
					String address = getRegistrationView().getRegAddressField().getText();
					
					System.out.println("foundUsername = " + foundUsername);
					
					if(!foundUsername && !password.equals("") && !name.equals("") && !paymentNum.equals("") && !address.equals("") && !email.equals(""))
					{
						userDashboard = new RegisteredUserDashboard();
						setUserDashboardButtonListener();
						setRegisteredUserDashboardButtonListener();
						changeApplicationView(changeToRegistrationView(), changeToUserDashboard());
						getUserRepo().addRegisteredUser(email, name, password, paymentNum, address);
						setRegisteredUser(getUserRepo().getRegisteredUser(email));
						System.out.println(getRegisteredUser().getRegistrationDate());
					}
					else if(!foundUsername && (password.equals("") || name.equals("") || paymentNum.equals("") || address.equals("") || email.equals("")))
					{
						getRegistrationView().getRegConfirmLabel().setText("Error, must fill in all fields");
					}
					else if(foundUsername)
					{
						getRegistrationView().getRegConfirmLabel().setText("Error, user email already in database");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(e.getSource().equals(getRegistrationView().getBackButton()))
			{
				System.out.println("Registration back button clicked");
				revertToApplicationView(getRegistrationView().getRegPanel());
			}
		}
	};

	ActionListener registeredUserDashboardListener = new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource().equals(((RegisteredUserDashboard)getUserDashboard()).getPayAnnualFeeButton()))
			{
				System.out.println("Pay annual fee button clicked");
				myPayAnnualFeeController = new PayAnnualFeeController(createPayAnnualFeeView()
				,currentRegisteredUserUserController());
				changeApplicationView(changeToUserDashboard(), ShowPayAnnualFeeView());
			}
			else if(e.getSource().equals(((RegisteredUserDashboard)getUserDashboard()).getViewMovieNewsButton()))
			{
				System.out.println("Movie news button clicked");
				movieNewsController = new MovieNewsController(currentRegisteredUserController());
				changeApplicationView(changeToUserDashboard(), changeToMovieNewsView());
			}
		}
	};
	
	public PayAnnualFeeView createPayAnnualFeeView() {

        String registrationDate = registeredUser.getRegistrationDate() + " " + "00:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime registerationDateTime = LocalDateTime.parse(registrationDate, formatter);
        LocalDateTime currentDateTime = LocalDateTime.now();

        long leftDays = 365 - (DAYS.between(registerationDateTime, currentDateTime));

        return this.payAnnualFeeView = new PayAnnualFeeView((int) leftDays, 150);
    }
	
	public PayAnnualFeeController getPayAnnualFeeController(){
		return myPayAnnualFeeController;
	}
	public RegisteredUserController currentRegisteredUserUserController(){
		return this;
	}
	public JPanel ShowPayAnnualFeeView() {
		return this.payAnnualFeeView.getpayAnnualFeePanel();
	}
	
	public LoginView getLoginView()
	{
		return loginView;
	}
	
	public RegistrationView getRegistrationView()
	{
		return regView;
	}
	
	public RegisteredUserController currentRegisteredUserController()
	{
		return this;
	}

	public UserRepository getUserRepo() {
		return userRepo;
	}

	public void setUserRepo(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
}
