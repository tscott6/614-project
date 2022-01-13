package model;
import java.util.ArrayList;

//TODO: this class is kinda useless 
import repository.ShowingRepository;

//TODO: this class needs to implement the QueryDatabase method
public class MovieCatalog {
	private ArrayList <Movie> runningMovies;
	
	public MovieCatalog() {
		setRunningMovies();
	}
	
	public ArrayList <Movie> getMovies() {
		return runningMovies;
	}
	
	// For temporary simulation and development, replace with JDBC connection
	public void setRunningMovies() {
		ShowingRepository repo = new ShowingRepository();
		repo.initializeConnection();
		runningMovies = repo.getMoviesUser("Released");
	}

}
