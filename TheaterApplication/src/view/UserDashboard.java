package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserDashboard {
	
	protected GridBagConstraints gbc;
	
	protected JPanel userDashboardPanel;
	protected JButton findMovieButton;
	protected JButton cancelBookingButton;
	protected JButton exitButton;
	
	public UserDashboard()
	{
		userDashboardPanel = new JPanel();
		userDashboardPanel.setBounds(0, 0, 800, 400);
		userDashboardPanel.setLayout(new GridBagLayout());
		
		findMovieButton = new JButton("Search Movie");
		cancelBookingButton = new JButton("Cancel Booking");
		exitButton = new JButton("Exit");
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		gbc.gridx = 0; gbc.gridy = 0;
		userDashboardPanel.add(findMovieButton, gbc);
		gbc.gridx = 0; gbc.gridy = 1;
		userDashboardPanel.add(cancelBookingButton, gbc);
		gbc.gridx = 0; gbc.gridy = 2;
		userDashboardPanel.add(exitButton, gbc);
	}
	
	public JPanel getUserDashboardPanel()
	{
		return userDashboardPanel;
	}
	
	public JButton getFindMovieButton()
	{
		return findMovieButton;
	}
	
	public JButton getCancelBookingButton()
	{
		return cancelBookingButton;
	}
	
	public JButton getExitButton()
	{
		return exitButton;
	}

}
