package model;

import controller.TheaterApp;
import repository.BankRepository;

public class Payment{
	
	BankRepository bankRepo;
	
	public Payment() {
		this.bankRepo = new BankRepository("jdbc:mysql://localhost:3306/moviebookingdb", "root", TheaterApp.getServerPassword());
	}
	

	public boolean processTransaction(String name, String creditCardNumber, int cvv, int expiryDate,
			double amount) {
		bankRepo.initializeConnection();
		return bankRepo.checkCreditCard(creditCardNumber);
	}

}
