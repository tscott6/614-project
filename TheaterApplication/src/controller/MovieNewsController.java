package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;

import view.MovieNews;
import model.Movie;
import repository.ShowingRepository;

public class MovieNewsController {
	
	private MovieNews movieNewsView;
	private UserController userController;
	private ShowingRepository newMovieRepo;
	
	public MovieNewsController(UserController control)
	{
		this.userController = control;
		this.movieNewsView = new MovieNews();
		this.setMovieNewsViewListener();
		
		this.newMovieRepo = new ShowingRepository();
		newMovieRepo.initializeConnection();
		
		try {
			setMovieNewsList();
		} catch (SQLException e) {
			System.out.println("Error in accessing movie names from database. Showing table may have no entries.");
			e.printStackTrace();
		}
	}
	
	public void setMovieNewsViewListener()
	{
		this.getMovieNewsView().getBackButton().addActionListener(MovieNewsListener);
	}
	
	ActionListener MovieNewsListener = new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource().equals(getMovieNewsView().getBackButton()))
			{
				System.out.println("Movie news back button clicked");
				returnToUserDashboard();
			}
		}
	};
	
	public MovieNews getMovieNewsView()
	{
		return movieNewsView;
	}
	
	public JPanel getMovieNewsPanel()
	{
		return getMovieNewsView().getMovieNewsPanel();
	}
	
	public void setMovieNewsList() throws SQLException
	{
		ArrayList<Movie> earlyMovies = new ArrayList<>(newMovieRepo.getShowingsRegisteredUser());
		String updatedMovies = "";
		
		getMovieNewsView().getMovieNewsList().setText("");
		getMovieNewsView().getMovieNewsList().setText("Upcoming Movie Releases\n");
		
		for(int i = 0; i < earlyMovies.size(); i++)
		{
			updatedMovies = updatedMovies + earlyMovies.get(i).toString() + "\n";
		}
		
		getMovieNewsView().getMovieNewsList().append(updatedMovies);
	}
	
	public void returnToUserDashboard()
	{
		this.userController.changeApplicationView(getMovieNewsView().getMovieNewsPanel(), 
				this.userController.changeToUserDashboard());
		
	}

}
