package repository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import controller.TheaterApp;
import model.Seat;

import java.sql.*;

public class CancellationRepository {
	
    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;    
    
//Optional to include, but recommended    

    private Connection dbConnect;
    private ResultSet results;
    
    public CancellationRepository(){

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

	
	public void createCancellation(int ticketID, String dateCancellation, double credit) {
		try {
			String query = "INSERT INTO Cancellation (TicketID, DateCancellation, Credit ) VALUES (?, ?, ?)";
			PreparedStatement myStmt = dbConnect.prepareStatement(query);
			
            myStmt.setInt(1, ticketID);
            myStmt.setDate(2, Date.valueOf(dateCancellation));
            myStmt.setDouble(3, credit);
            
            int rowCount = myStmt.executeUpdate();
            
            myStmt.close();
            
		} catch (SQLException ex) {
            ex.printStackTrace();
        }
		
	}
	
	public double getCredit(int ticketID) {
		
		double amount = 0;
		
		try {

			String query = "SELECT Credit FROM cancellation WHERE TicketID = ?;";
			PreparedStatement myStmt = dbConnect.prepareStatement(query);

			myStmt.setString(1, String.valueOf(ticketID));	
            
			results = myStmt.executeQuery();
			
            while (results.next()){
    			amount = results.getDouble("Credit");
            }	
			
			myStmt.close();
			
		} catch (SQLException ex) {
            ex.printStackTrace();
        }
		
		return amount;
	}
	
}
