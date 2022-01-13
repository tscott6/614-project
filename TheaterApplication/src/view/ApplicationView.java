package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

public final class ApplicationView extends JFrame {
	
	private static ApplicationView instance;
	
	private GridBagConstraints gbc;
	
	private JPanel appPanel;
	private JLabel freeUserLabel;
	private JButton loginButton;
	private JButton registerButton;
	private JButton continueButton;
	private JButton quitButton;
	
	private ApplicationView()
	{
		super("Theatre Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		appPanel = new JPanel();
		appPanel.setBounds(0, 0, 800, 400);
		appPanel.setLayout(new GridBagLayout());
		
		freeUserLabel = new JLabel("Continue as Free User");
		loginButton = new JButton("Login");
		registerButton = new JButton("Register");
		continueButton = new JButton("Continue");
		quitButton = new JButton("Quit");
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		gbc.gridx = 1; gbc.gridy = 0;
		appPanel.add(freeUserLabel, gbc);
		gbc.gridx = 0; gbc.gridy = 1;
		appPanel.add(loginButton, gbc);
		gbc.gridx = 1; gbc.gridy = 1;
		appPanel.add(continueButton, gbc);
		gbc.gridx = 0; gbc.gridy = 2;
		appPanel.add(registerButton, gbc);
		gbc.gridx = 1; gbc.gridy = 2;
		appPanel.add(quitButton, gbc);
		
		add(appPanel);
	}
	
	public JButton getLoginButton()
	{
		return loginButton;
	}
	
	public JButton getRegistrationButton()
	{
		return registerButton;
	}
	
	public JButton getContinueButton()
	{
		return continueButton;
	}
	
	public JButton getQuitButton()
	{
		return quitButton;
	}
	
	public JPanel getAppPanel()
	{
		return appPanel;
	}
	
	public void run()
	{
		this.setSize(800, 400);
		this.setVisible(true);
	}
	
	public static ApplicationView getInstance()
	{
		if(instance == null)
		{
			instance = new ApplicationView();
		}
		
		return instance;
	}
}