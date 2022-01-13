package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegisteredUserDashboard extends UserDashboard {
	
	private JButton payAnnualFeeButton;
	private JButton viewMovieNewsButton;
	
	public RegisteredUserDashboard()
	{
		payAnnualFeeButton = new JButton("Pay Annual Fee");
		viewMovieNewsButton = new JButton("Movie News");
		
		gbc.gridx = 0; gbc.gridy = 0;
		userDashboardPanel.add(findMovieButton, gbc);
		gbc.gridx = 0; gbc.gridy = 1;
		userDashboardPanel.add(cancelBookingButton, gbc);
		gbc.gridx = 0; gbc.gridy = 2;
		userDashboardPanel.add(payAnnualFeeButton, gbc);
		gbc.gridx = 0; gbc.gridy = 3;
		userDashboardPanel.add(viewMovieNewsButton, gbc);
		gbc.gridx = 0; gbc.gridy = 4;
		userDashboardPanel.add(exitButton, gbc);
	}
	
	public JButton getPayAnnualFeeButton()
	{
		return payAnnualFeeButton;
	}
	
	public JButton getViewMovieNewsButton()
	{
		return viewMovieNewsButton;
	}
}
