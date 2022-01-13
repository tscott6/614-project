package model;

import java.util.ArrayList;
//TODO: We need a method to get only available seats
//THIS MAY BE ANOTHER USELESS CLASS
public class Theater {
    private int numberofSeats;
    private String location;
    private int theaterID;
    private ArrayList<Seat> seats;
    
    public Theater(int numberofSeats, String location, int theaterID, ArrayList<Seat> seats) {
        this.numberofSeats = numberofSeats;
        this.location = location;
        this.theaterID = theaterID;
        this.seats = seats;
    }

    public Theater(int numberofSeats, String location, int theaterID) {
        this.numberofSeats = numberofSeats;
        this.location = location;
        this.theaterID = theaterID;
        seats = new ArrayList<Seat>(); // Here is the composition
        for (int i = 0; i < numberofSeats; i++) {
        	Seat seat = new Seat(i,i, true);
        	seats.add(seat);        	
        }
    }

    public Boolean getSeatAvailable() {
        // TODO: Need login implementation, why? We keep track of the seats available in the database
        return true;
    }

    public void setSeatAvailable(boolean state) {
        // TODO: Need login implementation
    }

    public int getNumberofSeats() {
        return this.numberofSeats;
    }

    public void setNumberofSeats(int numberofSeats) {
        this.numberofSeats = numberofSeats;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTheaterID() {
        return this.theaterID;
    }

    public void setTheaterID(int theaterID) {
        this.theaterID = theaterID;
    }

    public ArrayList<Seat> getSeats() {
        return this.seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }

}
