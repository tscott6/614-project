package model;

import java.util.ArrayList;

public class Showing {
	// This is a small entity class that can be used to pass information around within the system
	// An instances can be created by using the result of a query on the database using the selected movie
	private int theaterNum;
//	private String movie; // For the system entity we really only need the movie name, can keep it simple babyyyy
	private String date;
	private String time;
	private String location;
	private int showingNum;
	
	public Showing(int showingNum, String date, String time, String location, int theaterNum) {
		this.showingNum = showingNum;
		this.date = date;
		this.time = time;
		this.location = location;
		this.theaterNum = theaterNum;
	}

	public int getTheater() {
		return theaterNum;
	}

	public void setTheater(int theaterNum) {
		this.theaterNum = theaterNum;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public String getAvailableSeats() {
		return "";
	}

	public int getShowingNum() {
		return showingNum;
	}

	public void setShowingNum(int showingNum) {
		this.showingNum = showingNum;
	}
	public void setLocation(String s) {
		 location = s;
	}
	
	
	public String getLocation() {
		return location;
	}
	
	@Override
	public String toString() {
		return String.format("%d: %s at %s in theater %d at %s", showingNum, date, time, theaterNum, location);
	}

}
