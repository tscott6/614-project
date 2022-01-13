package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.TheaterApp;
import model.Movie;
import model.Showing;

public class ShowingRepository {

    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;    
    
//Optional to include, but recommended    

    private Connection dbConnect;
    private ResultSet results;
    
    public ShowingRepository(){

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
    
    public Movie getMovie (String mname) {
		String name = "";
		String genre = "";
		String ageRating = "";
		try {
            String query = "SELECT DISTINCT MovieName, Genre, AgeRating FROM Showing WHERE (MovieName = ?);";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.setString(1, mname);

            // Execute SQL query
            results = myStmt.executeQuery(); // Do not put query in these parentheses again
            
            // Process the results set
            while (results.next()){
            	name = results.getString("MovieName");
            	genre = results.getString("Genre");
            	ageRating = results.getString("AgeRating");
            }		
			myStmt.close();
			
		} catch (SQLException ex) {
            ex.printStackTrace();
        }
		
		return new Movie(name, genre, ageRating);
    	
    }
    
    
    
	public ArrayList <Movie> getMoviesUser(String type){ // Drop down pick movie
    	ArrayList<Movie> availableMovies = new ArrayList <Movie>();
		
		try {
            String query = "SELECT DISTINCT MovieName, Genre, AgeRating FROM Showing WHERE (Type = ?);";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.setString(1, type);

            // Execute SQL query
            results = myStmt.executeQuery(); // Do not put query in these parentheses again
            
            // Process the results set
            while (results.next()){
            	String name = results.getString("MovieName");
            	String genre = results.getString("Genre");
            	String ageRating = results.getString("AgeRating");
            	Movie movie = new Movie(name, genre, ageRating);
            	availableMovies.add(movie);
            }		
			myStmt.close();
			
		} catch (SQLException ex) {
            ex.printStackTrace();
        }
		
		return availableMovies;
			
	}
	
	public ArrayList <Movie> getMoviesRegisteredUser(){ // Drop down pick movies + early
    	ArrayList<Movie> allMovies = new ArrayList <Movie>();
		
		try {
            String query = "SELECT DISTINCT ShowingIdMovieName, ShowingDate, ShowingTime,  FROM Showing;";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            // Execute SQL query
            results = myStmt.executeQuery(); // Do not put query in these parentheses again
            
            // Process the results set
            while (results.next()){
            	String name = results.getString("MovieName");
            	String genre = results.getString("Genre");
            	String ageRating = results.getString("AgeRating");
            	Movie movie = new Movie(name, genre, ageRating);
            	allMovies.add(movie);
            }		
			myStmt.close();
			
		} catch (SQLException ex) {
            ex.printStackTrace();
        }
		
		return allMovies;	
	}
	
	public ArrayList <Showing> getShowingsUser(String movieName){ // Drop down pick movie
    	ArrayList<Showing> showings = new ArrayList <Showing>();
		
		try {
            String query = "SELECT DISTINCT ShowingId, ShowingDate, ShowingTime, Location, TheaterID"
            		+ " FROM Showing"
            		+ " INNER JOIN Seat"
            		+ " ON Showing.ShowingId = Seat.Showing"
            		+ " WHERE MovieName=?;";
            System.out.println(movieName);
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.setString(1, movieName);

            // Execute SQL query
            results = myStmt.executeQuery(); // Do not put query in these parentheses again
            
            // Process the results set
            while (results.next()){
            	int id = results.getInt("ShowingId");
            	String date = results.getString("ShowingDate");
            	String time = results.getString("ShowingTime");
            	String location = results.getString("Location");
            	int theaterNum = results.getInt("TheaterId");
            	Showing showing = new Showing(id, date, time, location, theaterNum);
            	showings.add(showing);
            }		
			myStmt.close();
			
		} catch (SQLException ex) {
            ex.printStackTrace();
        }
		
		return showings;	
	}
	
	public ArrayList <Movie> getShowingsRegisteredUser() throws SQLException{ // Drop down pick movies + early
        ArrayList<Movie> m = null;

        String query = "SELECT * FROM showing WHERE (Type = ?);";
        PreparedStatement myStmt = dbConnect.prepareStatement(query);
        myStmt.setString(1, "Early");

        results = myStmt.executeQuery();
        ArrayList <Movie> movieRequests = new ArrayList<Movie>();

        while (results.next()) {
            Movie ar = new Movie(results.getString("MovieName"), results.getString("Genre"), results.getString("AgeRating"));
            movieRequests.add(ar);
            m = movieRequests;
        }
        myStmt.close();

        return m;
	}
	
}
