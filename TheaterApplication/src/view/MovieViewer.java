package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import model.Movie;

@SuppressWarnings("serial")
public class MovieViewer extends JFrame{ 
	
    private JPanel headerPanel;
    private JButton backButton;         
    private JLabel headerLabel;	 
	private JComboBox<String> movieList;
    
    private final JButton seeViewTimesButton; 

    public MovieViewer() {
    	
        headerPanel = new JPanel();
        headerLabel = new JLabel("MOVIE SELECTOR");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 25));
        backButton = new JButton("BACK");
        seeViewTimesButton = new JButton("SEE VIEW TIMES");
        movieList = new JComboBox<String>();

        setPreferredSize(new Dimension(400, 275));     
        getContentPane().setLayout(new GridLayout(4,1));  
        getContentPane().add(headerPanel);
    	getContentPane().add(movieList);
    	getContentPane().add(Box.createGlue());
    	getContentPane().add(seeViewTimesButton);
        
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.X_AXIS));   
        headerPanel.add(Box.createGlue());
        headerPanel.add(headerLabel);
        headerPanel.add(Box.createGlue());
        headerPanel.add(Box.createGlue());
        headerPanel.add(backButton);
        headerPanel.add(Box.createGlue());
        
        movieList.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(),
                "MOVIE CATALOG",
                TitledBorder.CENTER,
                TitledBorder.TOP));
        
        pack();  
        setVisible(true);
    }
    
    
    public void addMovieActionListeners(ActionListener e) {
    	backButton.addActionListener(e);
    	seeViewTimesButton.addActionListener(e);
    }
    
    public JButton getBackButton() {
    	return backButton;
    }
    
    public JComboBox<String> getMovieDropDwn() {
    	return movieList;
    }


	public JButton getSeeViewTimesButton() {
		return seeViewTimesButton;
	}

}