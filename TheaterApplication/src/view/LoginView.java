package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

public class LoginView 
{
	
	private GridBagConstraints gbc;
	
	private JPanel loginPanel;
	private JTextField loginNameField;
	private JTextField loginIDField;
	private JLabel loginNameLabel;
	private JLabel loginIDLabel;
	private JLabel loginConfirmLabel;
	private JButton loginButton;
	private JButton backButton;
	
	public LoginView()
	{
		loginPanel = new JPanel();
		loginPanel.setBounds(0, 0, 800, 400);
		loginPanel.setLayout(new GridBagLayout());
		loginNameField = new JTextField();
		loginIDField = new JTextField();
		loginNameLabel = new JLabel("Email");
		loginIDLabel = new JLabel("Password");
		loginConfirmLabel = new JLabel();
		loginButton = new JButton("Login");
		backButton = new JButton("Back");
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		gbc.gridx = 0; gbc.gridy = 0;
		loginPanel.add(loginNameLabel, gbc);
		gbc.gridx = 1; gbc.gridy = 0;
		loginPanel.add(loginNameField, gbc);
		gbc.gridx = 0; gbc.gridy = 1;
		loginPanel.add(loginIDLabel, gbc);
		gbc.gridx = 1; gbc.gridy = 1;
		loginPanel.add(loginIDField, gbc);
		gbc.gridx = 1; gbc.gridy = 2;
		loginPanel.add(loginButton, gbc);
		gbc.gridx = 1; gbc.gridy = 3;
		loginPanel.add(backButton, gbc);
		gbc.gridx = 1; gbc.gridy = 4;
		loginPanel.add(loginConfirmLabel, gbc);
	}
	
	public JPanel getLoginPanel()
	{
		return loginPanel;
	}
	
	public JButton getLoginButton()
	{
		return loginButton;
	}
	
	public JButton getBackButton()
	{
		return backButton;
	}
	
	public JTextField getLoginNameField()
	{
		return loginNameField;
	}
	
	public JTextField getLoginIDField()
	{
		return loginIDField;
	}
	
	public JLabel getLoginConfirmLabel()
	{
		return loginConfirmLabel;
	}
}
