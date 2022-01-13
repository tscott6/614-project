package model;

public class Receipt {
	
	private String amount;
	private String creditCardNumber;
	private String movieName;

	public Receipt(double amount, String creditCardNumber, String movieName) {
		this.amount = String.valueOf(amount);
		this.creditCardNumber = creditCardNumber;
		this.movieName = movieName;
	}
	
	public Receipt(double amount, String creditCardNumber) {
		this.amount = String.valueOf(amount);
		this.creditCardNumber = creditCardNumber;
	}
	

	public String ticketPaymentString() {
		return "*******************************************\n"
				+ "            RECEIPT\n" 
				+ "****************************************\n"
				+ "----------------------------------------\n"
				+ movieName
				+ "                             " 
				+ "----------------------------------------\n\n"
				+ "TOTAL AMOUNT                        " 
				+ amount
				+ "\n\n" 
				+ "Bank Card Number:       **** **** **** "
				+ creditCardNumber.substring(creditCardNumber.length() - 4);
				
	}
	
	public String payAnnualFeeString() {
		
		return "*********************************************\n"
				+ "                   RECEIPT\n" 
				+ "*********************************************\n"
				+ "--------------------------------------------------------\n"
				+ "Annual Membership"
				+ "                             " 
				+ amount + "\n"
				+ "--------------------------------------------------------\n\n"
				+ "Total AMOUNT"
				+ "                                       "  
				+ amount
				+ "\n\n" 
				+ "Bank Card Number:      **** **** **** "
				+ creditCardNumber.substring(creditCardNumber.length() - 4);
		
	}
	

}
