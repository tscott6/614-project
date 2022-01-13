package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegistrationView {
	
	private GridBagConstraints gbc;
	
	private JPanel regPanel;
	private JTextField regNameField;
	private JTextField regEmailField;
	private JTextField regPasswordField;
	private JTextField regBankCardField;
	private JLabel regNameLabel;
	private JLabel regEmailLabel;
	private JLabel regPasswordLabel;
	private JLabel regBankCardLabel;
	private JLabel regConfirmLabel;
	private JButton regButton;
	private JButton backButton;
	private JTextField regAddressField;
	private JLabel regAddressLabel;

	
	
	public RegistrationView()
	{
		regAddressField = new JTextField();
		regAddressLabel = new JLabel("Address");
		regPanel = new JPanel();
		regPanel.setBounds(0, 0, 800, 400);
		regPanel.setLayout(new GridBagLayout());
		regNameField = new JTextField();
		regEmailField = new JTextField();
		regPasswordField = new JTextField();
		regBankCardField = new JTextField();
		regNameLabel = new JLabel("Name");
		regEmailLabel = new JLabel("Email");
		regPasswordLabel = new JLabel("Password");
		regBankCardLabel = new JLabel("Credit Card Number");
		regConfirmLabel = new JLabel();
		regButton = new JButton("Register");
		backButton = new JButton("Back");
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		gbc.gridx = 0; gbc.gridy = 0;
		regPanel.add(regNameLabel, gbc);
		gbc.gridx = 1; gbc.gridy = 0;
		regPanel.add(regNameField, gbc);
		gbc.gridx = 0; gbc.gridy = 1;
		regPanel.add(regEmailLabel, gbc);
		gbc.gridx = 1; gbc.gridy = 1;
		regPanel.add(regEmailField, gbc);
		
		gbc.gridx = 0; gbc.gridy = 2;
		regPanel.add(regPasswordLabel, gbc);
		gbc.gridx = 1; gbc.gridy = 2;
		regPanel.add(regPasswordField, gbc);
		gbc.gridx = 0; gbc.gridy = 3;
		regPanel.add(regBankCardLabel, gbc);
		gbc.gridx = 1; gbc.gridy = 3;
		regPanel.add(regBankCardField, gbc);
		gbc.gridx = 0; gbc.gridy = 4;
		regPanel.add(regAddressLabel, gbc);
		gbc.gridx = 1; gbc.gridy = 4;
		regPanel.add(regAddressField, gbc);
		gbc.gridx = 1; gbc.gridy = 5;
		regPanel.add(regButton, gbc);
		gbc.gridx = 1; gbc.gridy = 6;
		regPanel.add(backButton, gbc);
		gbc.gridx = 1; gbc.gridy = 7;
		regPanel.add(regConfirmLabel, gbc);
	}
	
	public JPanel getRegPanel()
	{
		return regPanel;
	}
	
	public JButton getRegButton()
	{
		return regButton;
	}
	
	public JButton getBackButton()
	{
		return backButton;
	}
	
	public JTextField getRegNameField()
	{
		return regNameField;
	}
	
	public JTextField getRegEmailField()
	{
		return regEmailField;
	}
	
	public JTextField getRegPasswordField()
	{
		return regPasswordField;
	}
	
	public JTextField getRegBankCardField()
	{
		return regBankCardField;
	}
	
	public JLabel getRegConfirmLabel()
	{
		return regConfirmLabel;
	}

	public JTextField getRegAddressField() {
		return regAddressField;
	}

}
