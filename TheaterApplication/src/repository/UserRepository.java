package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import controller.TheaterApp;
import model.RegisteredUser;
import model.Seat;

public class UserRepository implements Repository{
	
    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;    
    
//Optional to include, but recommended    

    private Connection dbConnect;
    private ResultSet results;
    
    public UserRepository(){

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

	
//	public RegisteredUser getRegisteredUser(int userID) {
//		
//		RegisteredUser user = null;
//		
//		try {
//            
//            String query = "SELECT * FROM user WHERE UserID = ?;";
//            PreparedStatement myStmt = dbConnect.prepareStatement(query);
//            
//            myStmt.setString(1, String.valueOf(userID));
//
//            // Execute SQL query
//            results = myStmt.executeQuery(); // Do not put query in these parentheses again
//            
//            // Process the results set
//            while (results.next()){
//            	String userEmail = results.getString("userEmail");
//            	String userPassword = results.getString("rowFromFront");
//            	String registrationDate = results.getString("RegistrationDate");
//            	String name = results.getString("Name");
//            	String address = results.getString("Address");
//            	String creditCardNumber = results.getString("CreditCardNumber");
//            	
//            	user = new RegisteredUser (name, userEmail, userPassword, registrationDate, 
//            			creditCardNumber, address);
//            }		
//			
//			myStmt.close();
//			
//		} catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//		
//		
//		return user;
//		
//	}
	
	public void addUser(String userEmail, String userPassword, String registrationDate) {
		
		try {
			String query = "INSERT INTO user (userEmail, password, RegistrationDate) VALUES (?, ?, ?)";
			PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setString(1, userPassword);
            myStmt.setString(2, userPassword);
            myStmt.setString(3,registrationDate);
            
            int rowCount = myStmt.executeUpdate();
            
            myStmt.close();
            
		} catch (SQLException ex) {
            ex.printStackTrace();
        }
		
	}
	
	public boolean checkUserEmail(String email) throws SQLException{
		String query = "SELECT * FROM user WHERE userEmail = ?";
		PreparedStatement myStmt = dbConnect.prepareStatement(query);
		myStmt.setString(1, email);
		boolean found = false;
		
		results = myStmt.executeQuery();
		if (results.next()) {
			found = true;
		}
		myStmt.close();

		return found;
	}
	
	public boolean checkUserPassword(String password) throws SQLException{
		String query = "SELECT * FROM user WHERE password = ?";
		PreparedStatement myStmt = dbConnect.prepareStatement(query);
		myStmt.setString(1, password);
		boolean found = false;
		
		results = myStmt.executeQuery();
		if (results.next()) {
			found = true;
		}
		myStmt.close();
	
		return found;
	}
		
	public void addRegisteredUser(String newUserEmail, String newName, String newPassword, String newCardNum, String newAddress) throws SQLException {
		String query = "INSERT INTO user (userEmail, name, password, paymentCardNum, address, registrationDate) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement myStmt = dbConnect.prepareStatement(query);
		myStmt.setString(1, newUserEmail);
		myStmt.setString(2, newName);
		myStmt.setString(3, newPassword); 
		myStmt.setString(4, newCardNum);
		myStmt.setString(5, newAddress);
		LocalDate regDate = java.time.LocalDate.now();
		myStmt.setString(6, regDate.toString());
		
		int rowCount = myStmt.executeUpdate();
		System.out.println("row Count = " + rowCount);
		
		myStmt.close();
		
		System.out.println(newUserEmail + " entered into database");
	}
	
	public RegisteredUser getRegisteredUser(String userEmail) throws SQLException {
		String query = "SELECT * FROM user WHERE userEmail=?";
		PreparedStatement myStmt = dbConnect.prepareStatement(query);
		myStmt.setString(1, userEmail);
		results = myStmt.executeQuery();
		while (results.next()) {
	    	String userPassword = results.getString("password");
	    	String registrationDate = results.getString("registrationDate");
	    	String creditCardNumber = results.getString("paymentCardNum");
	    	String name = results.getString("name");
	    	String address = results.getString("address");
			return new RegisteredUser(name, userEmail, userPassword, registrationDate, creditCardNumber, address);
		}
		return null;
	}
	
}
