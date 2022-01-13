
package repository;
import controller.TheaterApp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import model.Movie;
import model.Ticket;

public class TicketRepository {
	
	
    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;    
    

    private Connection dbConnect;
    private ResultSet results;
    
    public TicketRepository(){

    this.DBURL = "jdbc:mysql://localhost:3306/moviebookingdb";

    this.USERNAME = "root";
    this.PASSWORD = TheaterApp.getServerPassword();
    }

    public void initializeConnection(){
        
        try{
            dbConnect = DriverManager.getConnection(this.DBURL, this.USERNAME, this.PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    String getDburl(){
        return this.DBURL;
    }

    String getUsername(){
        return this.USERNAME;
    }
    
    String getPassword(){
        return this.PASSWORD;
    }
	
	public void createTicket(int ticketID, int userID, String location, int theaterID, int seatNumber, int rowFromFront,
			String movieName, String showingDate, String showingTime, String Status, double price) {
		
		try {
			String query = "INSERT INTO ticket (TicketID, UserID, Location, TheaterID, SeatNumber, RowFromFront,"
					+ " MovieName, ShowingDate, ShowingTime, Status, Price) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement myStmt = dbConnect.prepareStatement(query);
			
            myStmt.setInt(1, ticketID);
            myStmt.setInt(2, userID);
            myStmt.setString(3, location);
            myStmt.setInt(4, theaterID);
            myStmt.setInt(5, seatNumber);
            myStmt.setInt(6, rowFromFront);
            myStmt.setString(7, movieName);
            myStmt.setDate(8, Date.valueOf(showingDate));
            myStmt.setTime(9, Time.valueOf(showingTime));
            myStmt.setString(10, Status);
            myStmt.setDouble(11, price);
            
            int rowCount = myStmt.executeUpdate();
            
            myStmt.close();
            
		} catch (SQLException ex) {
            ex.printStackTrace();
        }
		
	}
	
	public Ticket getTickets(int ticketID){
		
		Ticket ticket = null;
	    int ticketId;
	    Movie theMovie;
	    int theaterID; // PK
	    String location; // PK
	    double price;
	    int theSeatNumber; // PK 
	    int rowFromFront; // PK
	    String date;
	    String time;
	    String status;
		
		try {

			String query = "SELECT * FROM ticket WHERE ticket.TicketID = ?;";
			PreparedStatement myStmt = dbConnect.prepareStatement(query);

			myStmt.setString(1, String.valueOf(ticketID));	
            
			results = myStmt.executeQuery();
			
            while (results.next()){
            	ticketId = results.getInt("TicketID");
            	String movieName = results.getString("MovieName");
            	String movieGenre = results.getString("Genre");
            	String ageRating = results.getString("AgeRating");
            	theaterID = results.getInt("TheaterID");
            	location = results.getString("Location");
            	price = results.getDouble("Price");
            	theSeatNumber = results.getInt("SeatNumber");
            	rowFromFront = results.getInt("RowFromFront");
            	date = results.getString("ShowingDate");
            	time = results.getString("ShowingTime");
            	status = results.getString("Status");
            	theMovie = new Movie(movieName, movieGenre, ageRating);
            	ticket = new Ticket(ticketId, theMovie, theaterID,  location, price, theSeatNumber, rowFromFront, date, time, status);
            }	
			
			myStmt.close();
			
		} catch (SQLException ex) {
            ex.printStackTrace();
        }
		
		return ticket;
	}
	
    public void setTicketStatus(int ticketID, String status) {

        try {
            String query = "UPDATE ticket SET Status = ? WHERE ticket.TicketID = ?;";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setString(1, status);
            myStmt.setInt(2, ticketID);

            myStmt.executeUpdate();

            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean isRegUser(int ticketId) {
    	String user = "";
        try {
            String query = "SELECT UserID FROM ticket WHERE TicketID = ?;";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.setInt(1, ticketId);

        	results = myStmt.executeQuery();
            while (results.next()) {
            	user = results.getString("UserID");
            }
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return (!user.equals("NA"));
    }
    
    
    public int getHighestID() {
    	int id = 0;
        try {
            String query = "SELECT MAX(TicketID) FROM ticket;";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

        	results = myStmt.executeQuery();
            while (results.next()) {
            	id = results.getInt("MAX(TicketID)");
            }
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return id;
    }

}
