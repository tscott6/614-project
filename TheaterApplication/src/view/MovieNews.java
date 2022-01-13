package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.MovieNewsController;
import controller.RegisteredUserController;
import controller.UserController;

public class MovieNews {
	
	private GridBagConstraints gbc;
	
	private JPanel movieNewsPanel;
	private JTextArea movieNewsList;
	private JButton backButton;
	
	public MovieNews()
	{
		movieNewsPanel = new JPanel();
		movieNewsPanel.setBounds(0, 0, 800, 400);
		movieNewsPanel.setLayout(new GridBagLayout());
		
		movieNewsList = new JTextArea();
		movieNewsList.setEditable(false);
		
		backButton = new JButton("Back");
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		gbc.gridx = 0; gbc.gridy = 0;
		movieNewsPanel.add(movieNewsList, gbc);
		gbc.gridx = 0; gbc.gridy = 1;
		movieNewsPanel.add(backButton, gbc);
	}
	
	public JButton getBackButton()
	{
		return backButton;
	}
	
	public JTextArea getMovieNewsList()
	{
		return movieNewsList;
	}
	
	public JPanel getMovieNewsPanel()
	{
		return movieNewsPanel;
	}

}
