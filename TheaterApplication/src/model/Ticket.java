package model;

import java.sql.Date;
import java.sql.Time;

public class Ticket {
    private int ticketId;
    private Movie theMovie;
    private int theaterID; // PK: Changed why should we have an entire object in movie. We just need ID
    private String location; // PK
    private double price;
    private int theSeatNumber; // PK
    private int rowFromFront; // PK
    private String showingDate;
    private String showingTime;
    private String status;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getShowingDate() {
        return this.showingDate;
    }

    public void setShowingDate(String showingDate) {
        this.showingDate = showingDate;
    }

    public String getShowingTime() {
        return this.showingTime;
    }

    public void setShowingTime(String showingTime) {
        this.showingTime = showingTime;
    }

    public Ticket(int ticketId, Movie theMovie, int theaterID, String location, double price, int theSeatNumber,
            int rowFromFront, String showingDate, String showingTime, String status) {
        super();
        this.ticketId = ticketId;
        this.theMovie = theMovie;
        this.theaterID = theaterID;
        this.location = location;
        this.price = price;
        this.theSeatNumber = theSeatNumber;
        this.rowFromFront = rowFromFront;
        this.showingDate = showingDate;
        this.showingTime = showingTime;
        this.status = status;
    }

    // TODO: BS: Remove this constructer
    public Ticket() {
    }

    public int getTicketId() {
        return this.ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public Movie getTheMovie() {
        return this.theMovie;
    }

    public void setTheMovie(Movie theMovie) {
        this.theMovie = theMovie;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTheSeatNumber() {
        return this.theSeatNumber;
    }

    public void setTheSeatNumber(int theSeatNumber) {
        this.theSeatNumber = theSeatNumber;
    }

    public void sendToCustomer() {

    }

    public int getRowFromFront() {
        return rowFromFront;
    }

    public void setRowFromFront(int rowFromFront) {
        this.rowFromFront = rowFromFront;
    }

    public int getTheaterID() {
        return theaterID;
    }

    public void setTheaterID(int theaterID) {
        this.theaterID = theaterID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

//    @Override
//    public String toString() {
//        return "*******************************************\n"
//                + "            TICKET\n"
//                + "****************************************\n"
//                + "----------------------------------------\n"
//                + "Ticket ID:" + ticketId
//                + "                             "
//                + "Movie name:" + this.getTheMovie().getName() + "\n"
//                + "Seat numer:" + this.getTheSeatNumber() + "\n"
//                + "Show Date:" + this.getShowingDate() + "\n"
//                + "Show Time:" + this.getShowingTime() + "\n"
//                + "----------------------------------------\n\n"
//                + "\n\n";
//
//    }
    
    @Override
    public String toString() {
        return "***\n"
                + "            TICKET\n"
                + "**\n"
                + "----------------------------------------\n"
                + "Ticket ID:" + ticketId
                + "                     "
                + "Movie Name:" + this.getTheMovie().getName() + "\n"
                + "Seat Number:" + this.getTheSeatNumber() + "\n"
                + "Show Date:" + this.getShowingDate() + "\n"
                + "Show Time:" + this.getShowingTime() + "\n"
                + "Location:" + this.getLocation() + "\n"
                + "Ticket Price:" + this.getPrice() + "\n"
                + "----------------------------------------\n\n"
                + "\n\n";

    }

}