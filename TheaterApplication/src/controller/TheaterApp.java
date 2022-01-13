package controller;
import view.ApplicationView;


// Entry point for entire application
public class TheaterApp {

	static String mysqlPassword;

	public static void main(String[] args) 
	{
		// TODO: MYSQL PASSWORD GLOBAL VARIABLE
		Application app = Application.getInstance();
//		mysqlPassword = args[0];
		mysqlPassword = "Bigdata22!";
		app.run();
	}
	
	public static String getServerPassword() {
		return mysqlPassword;
	}

}
