package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankRepository {
	
    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;    
    
//Optional to include, but recommended    

    private Connection dbConnect;
    private ResultSet results;
    
    public BankRepository(String DBURL, String USERNAME, String PASSWORD){

        // Database URL
        this.DBURL = DBURL;

        //  Database credentials
        this.USERNAME = USERNAME; 
        this.PASSWORD = PASSWORD; 
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

	public boolean checkCreditCard(String creditCardNumber) {
		
		boolean paymentStatus = false;
		
		try {
            
            String query = "SELECT * FROM bank;";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            // Execute SQL query
            results = myStmt.executeQuery(); // Do not put query in these parentheses again
            
            // Process the results set
            while (results.next()){

            	if (results.getString("paymentCardNum").equals(creditCardNumber)) {
            		paymentStatus = true;
            	}
            }		
			
			myStmt.close();
			
		} catch (SQLException ex) {
            ex.printStackTrace();
        }
		
		return paymentStatus;
		
	}


}
