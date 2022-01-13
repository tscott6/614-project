package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import controller.TheaterApp;
import model.Seat;

public class SeatRepository {
	
    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;    
    
//Optional to include, but recommended    

    private Connection dbConnect;
    private ResultSet results;
    
    public SeatRepository(){

    // Database URL
    this.DBURL = "jdbc:mysql://localhost:3306/moviebookingdb";

    //  Database credentials
    this.USERNAME = "root";
    this.PASSWORD = TheaterApp.getServerPassword();
    }

//Must create a connection to the database, no arguments, no return value    
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
    
    
    public ArrayList<Seat> getAvailableSeats(int showingId) {
    	
    	ArrayList<Seat> availableSeats = new ArrayList <Seat>();
		
		try {
            
            String query = "SELECT SeatNumber, rowFromFront, Status"
            		+ " FROM seat WHERE (Showing=? AND Status = 1);";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            
            myStmt.setInt(1, showingId);
            
            // Execute SQL query
            results = myStmt.executeQuery(); // Do not put query in these parentheses again
            
            // Process the results set
            while (results.next()){
            	int seatNumber = results.getInt("SeatNumber");
            	int rowFromFront = results.getInt("rowFromFront");
            	boolean status = (results.getInt("Status") != 0);
            	
            	Seat seat = new Seat(seatNumber, rowFromFront, status);
            	availableSeats.add(seat);
            }		
			
			myStmt.close();
			
		} catch (SQLException ex) {
            ex.printStackTrace();
        }
		
		return availableSeats;
    }
    //TODO
	public void changeSeatStatus(int SeatNumber, int rowFromFront, String location, int theaterID, boolean status) {
		try {
			String query = "UPDATE seat SET Status = ? WHERE (SeatNumber = ? AND rowFromFront = ? AND Location = ? AND TheaterID = ?);";
			PreparedStatement myStmt = dbConnect.prepareStatement(query);
            
			int intStatus = (status ? 1 : 0);
			
			myStmt.setInt(1, intStatus);	// Available = 1, Booked  = 0		
            myStmt.setInt(2, SeatNumber);
            myStmt.setInt(3, rowFromFront);
            myStmt.setString(4, location);
            myStmt.setInt(5, theaterID);
            
            int rowCount = myStmt.executeUpdate();
            
            myStmt.close();
            
		} catch (SQLException ex) {
            ex.printStackTrace();
        }
	}
				
}
