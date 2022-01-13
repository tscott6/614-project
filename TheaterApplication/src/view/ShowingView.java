package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class ShowingView extends JFrame{
	 	private JPanel headerPanel;
	    private JButton backButton;
	    private JLabel headerLabel;
		private JComboBox<String> showtimeList;
		private JComboBox<String> availableSeats;
		private JButton selectSeatButton;	    
	    private JButton seeSeatsButton; 

	    public ShowingView(String movieName) {
	        headerPanel = new JPanel();
	        headerLabel = new JLabel("Showtimes for " + movieName);
	        headerLabel.setFont(new Font("Arial", Font.BOLD, 25));
	        backButton = new JButton("BACK");
	        seeSeatsButton = new JButton("SEE SEATS");
	        selectSeatButton = new JButton("GET SEAT");
	        showtimeList = new JComboBox<String>();
	    	availableSeats = new JComboBox<String>();

	        setPreferredSize(new Dimension(650, 300));     
	        getContentPane().setLayout(new GridLayout(4,1));  
	        getContentPane().add(headerPanel);
	    	getContentPane().add(showtimeList);
	    	getContentPane().add(availableSeats);
	    	getContentPane().add(selectSeatButton);

	        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.X_AXIS));   
	        headerPanel.add(Box.createGlue());
	        headerPanel.add(headerLabel);
	        headerPanel.add(Box.createGlue());
	        headerPanel.add(Box.createGlue());
	        headerPanel.add(backButton);
	        headerPanel.add(Box.createGlue());
	        headerPanel.add(seeSeatsButton);

	        
	        showtimeList.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(),
	                "SHOWTIMES",
	                TitledBorder.CENTER,
	                TitledBorder.TOP));
	        
	        pack();  
	        setVisible(true);
	    }
	    
	    
	    public void addShowingActionListeners(ActionListener e) {
	    	backButton.addActionListener(e);
	    	seeSeatsButton.addActionListener(e);
	    	selectSeatButton.addActionListener(e);
	    }
	    
	    public JButton getBackButton() {
	    	return backButton;
	    }
	    
	    public JComboBox<String> getShowingDropDwn() {
	    	return showtimeList;
	    }

		public JButton getSeeSeatsButton() {
			return seeSeatsButton;
		}

		public JButton getSelectSeatBtn() {
			return selectSeatButton;
		}

		public JComboBox<String> getAvailableSeats() {
			return availableSeats;
		}
}
