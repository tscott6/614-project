package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.Payment;
import model.Receipt;
import model.RegisteredUser;
import model.Ticket;
import view.PaymentViewReg;

public class PaymentControllerRegistered {
	
	Payment paymemt;
	PaymentViewReg paymentViewReg;
	String transactionType;
	Ticket ticket;
	Receipt receipt;
	double amount;
	RegisteredUser user;
	Application app;


	// Buying ticket constructor
	public PaymentControllerRegistered(Payment paymemt, PaymentViewReg paymentViewReg, String transactionType, Ticket ticket, double amount, 
			RegisteredUser user, Application app) {
		this.paymemt = paymemt;
		this.paymentViewReg = paymentViewReg;
		this.transactionType = transactionType;
		this.ticket = ticket;
		this.amount = amount;
		this.user = user;
		this.app = app;
		paymentViewReg.pay_addActionListener(new Pay_addActionListener());
		payViewCloseOp();
	}
	
	// Pay annual fee constructor
	public PaymentControllerRegistered(Payment paymemt, PaymentViewReg paymentViewReg, String transactionType, double amount, RegisteredUser user, 
			Application app) {
		this.paymemt = paymemt;
		this.paymentViewReg = paymentViewReg;
		this.transactionType = transactionType;
		this.amount = amount;
		this.user = user;
		this.app = app;
		paymentViewReg.pay_addActionListener(new Pay_addActionListener());
		payViewCloseOp();
	}
	
	public void payViewCloseOp() {
	    paymentViewReg.addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent e) {
	            System.out.println("Payment View quit without back button");
				app.getApplicationView().setVisible(true);
	        }
	    });
	}
	
	class Pay_addActionListener implements ActionListener{
		
		String name;
		String creditCardNumber;
		int cvv;
		int expiryDate;
		String email;
		boolean paymentStatus;
		Receipt receipt;
		
		@Override
		public void actionPerformed(ActionEvent e) {
				
			if (transactionType == "Movie") {
				name = user.getName();
				creditCardNumber = user.getCreditCardNumber();
				cvv = paymentViewReg.getCVV();
				expiryDate = paymentViewReg.getExpiryDate();
				email = user.getUserEmail();
				paymentStatus = paymemt.processTransaction(name, creditCardNumber, cvv, expiryDate, amount);
				if (paymentStatus == true) {
					receipt = new Receipt (amount, creditCardNumber, ticket.getTheMovie().getName());
					paymentViewReg.setDisplayReceipt(receipt.ticketPaymentString());
					paymentViewReg.setDisplayTicket(ticket.toString());
				} else {
					paymentViewReg.setDisplayReceipt("Transction Failed");
					paymentViewReg.setDisplayTicket(" ");
				}
			}
			
			else if (transactionType == "AnnualFee") {
				name = user.getName();
				creditCardNumber = user.getCreditCardNumber();
				cvv = paymentViewReg.getCVV();
				expiryDate = paymentViewReg.getExpiryDate();
				email = user.getUserEmail();
				paymentStatus = paymemt.processTransaction(name, creditCardNumber, cvv, expiryDate, amount);
				if (paymentStatus == true) {
					receipt = new Receipt (amount, creditCardNumber);
					paymentViewReg.setDisplayReceipt(receipt.payAnnualFeeString());
					paymentViewReg.setDisplayTicket(" ");
				} else {
					paymentViewReg.setDisplayReceipt("Transction Failed");
					paymentViewReg.setDisplayTicket(" ");
				}
			}
		}
	}

}
