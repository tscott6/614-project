package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.Payment;
import model.Receipt;
import model.RegisteredUser;
import model.Ticket;
import view.PaymentViewOrdinary;

public class PaymentControllerOrdinary {
	
	Payment paymemt;
	PaymentViewOrdinary paymentViewOrd;
	String transactionType;
	Ticket ticket;
	Receipt receipt;
	double amount;
	RegisteredUser user;
	UserController cntrl;
	
	// Return and Pay annual fee constructor
	public PaymentControllerOrdinary(Payment paymemt, PaymentViewOrdinary paymentViewOrd, String transactionType, Ticket ticket, double amount,
			UserController cntrl) {
		this.paymemt = paymemt;
		this.paymentViewOrd = paymentViewOrd;
		this.transactionType = transactionType;
		this.amount = amount;
		this.cntrl = cntrl;
		this.ticket = ticket;
		paymentViewOrd.pay_addActionListener(new Pay_addActionListener());
		payViewCloseOp();
	}
	
	public void payViewCloseOp() {
	    paymentViewOrd.addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent e) {
	            System.out.println("Payment View quit without back button");
				cntrl.getApplication().getApplicationView().setVisible(true);
				paymentViewOrd.setVisible(false);
				paymentViewOrd.dispose();
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
			
			if (transactionType.equals("Movie")) {
				name = paymentViewOrd.getName();
				creditCardNumber = paymentViewOrd.getCreditCardNumber();
				cvv = paymentViewOrd.getCVV();
				expiryDate = paymentViewOrd.getExpiryDate();
				email = paymentViewOrd.getEmail();
				paymentStatus = paymemt.processTransaction(name, creditCardNumber, cvv, expiryDate, amount);
				if (paymentStatus == true) {
					receipt = new Receipt (amount, creditCardNumber, ticket.getTheMovie().getName());
					paymentViewOrd.setDisplayReceipt(receipt.ticketPaymentString());
					paymentViewOrd.setDisplayTicket(ticket.toString());
				} else {
					paymentViewOrd.setDisplayReceipt("Transction Failed");
					paymentViewOrd.setDisplayTicket(" ");
				}
			}
		}
	}

}
