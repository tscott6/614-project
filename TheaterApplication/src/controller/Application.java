package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

import model.Movie;
import view.*;

public class Application implements ActionListener {
	
	private static Application instance;
	
	private ApplicationView applicationView;
	private UserController currentUser;
	
	private Application()
	{
		this.applicationView = ApplicationView.getInstance();
		this.setApplicationViewButtonListener();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource().equals(this.applicationView.getLoginButton()))
		{
			currentUser = new RegisteredUserController("LOGIN");
			currentUser.setApplication(this);
			this.changeApplicationView(this.applicationView.getAppPanel(), ((RegisteredUserController)this.currentUser).changeToLoginView());
			System.out.println("Login successful");
		} 
		else if (e.getSource().equals(this.applicationView.getRegistrationButton()))
		{
			currentUser = new RegisteredUserController("REGISTER");
			currentUser.setApplication(this);
			this.changeApplicationView(this.applicationView.getAppPanel(), ((RegisteredUserController)this.currentUser).changeToRegistrationView());
			System.out.println("Register successful");
		}
		else if (e.getSource().equals(this.applicationView.getContinueButton()))
		{
			this.currentUser = new UserController();
			this.currentUser.setApplication(this);
			this.currentUser.createUserDashboard();
			this.currentUser.setUserDashboardButtonListener();
			this.changeApplicationView(this.applicationView.getAppPanel(), this.currentUser.changeToUserDashboard());
			System.out.println("Continue successful");
		}
		else if (e.getSource().equals(this.applicationView.getQuitButton()))
		{
			System.exit(0);
		}
	}
	
	public void setApplicationViewButtonListener()
	{
		this.applicationView.getLoginButton().addActionListener(this);
		this.applicationView.getRegistrationButton().addActionListener(this);
		this.applicationView.getContinueButton().addActionListener(this);
		this.applicationView.getQuitButton().addActionListener(this);
	}
	
	public void changeApplicationView(JPanel currentPanel, JPanel newPanel)
	{
		this.applicationView.remove(currentPanel);
		this.applicationView.add(newPanel);
		this.applicationView.revalidate();
		this.applicationView.validate();
		this.applicationView.repaint();
	}
	
	public ApplicationView getApplicationView() 
	{
		return applicationView;
	}
	
	public void setCurrentUser(UserController newUser)
	{
		this.currentUser = newUser;
	}
	
	public void run()
	{
		applicationView.run();

	}
	
	public static Application getInstance()
	{
		if(instance == null)
		{
			instance = new Application();
		}
		
		return instance;
	}

}