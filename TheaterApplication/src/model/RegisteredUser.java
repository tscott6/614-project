package model;

public class RegisteredUser extends User {

	private String userEmail;
	private String userPassword;
	private String registrationDate;
	private String CreditCardNumber;
	private String Name;
	private String address;	
	
	public RegisteredUser(String name, String userEmail, String userPassword, String registrationDate,
			String creditCardNumber, String address) {
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.registrationDate = registrationDate;
		CreditCardNumber = creditCardNumber;
		Name = name;
		System.out.println("Registered User" + isRegUser);
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getCreditCardNumber() {
		return CreditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		CreditCardNumber = creditCardNumber;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	public boolean getIsRegUser() {
		return isRegUser;
	}

	public void setIsRegUser(boolean userType) {
		this.isRegUser = userType;
	}

}
