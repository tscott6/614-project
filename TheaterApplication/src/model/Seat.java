package model;

public class Seat {
    private int seatNumber;
    private int rowFromFront;
    private Boolean available;
    private int bookingID;
    
    //TODO: Why is there bookingID as a parameter???? This doesnt make sense
    public Seat(int seatNumber, int rowFromFront, Boolean available, int bookingID) {
        this.seatNumber = seatNumber;
        this.rowFromFront = rowFromFront;
        this.available = available;
        this.bookingID = bookingID;
    }
    
    public Seat(int seatNumber, int rowFromFront, Boolean available) {
        this.seatNumber = seatNumber;
        this.rowFromFront = rowFromFront;
        this.available = available;
    }
    

    public int getRowFromFront() {
        return this.rowFromFront;
    }

    public void setRowFromFront(int rowFromFront) {
        this.rowFromFront = rowFromFront;
    }

    public Boolean isAvailable() {
        return this.available;
    }

    public Boolean getAvailable() {
        return this.available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public int getBookingID() {
        return this.bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getSeatNumber() {
        return this.seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
    
    @Override
    public String toString() {
    	return String.format("%d: Row %d", seatNumber, rowFromFront);
    	
    }

}
