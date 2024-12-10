package Java.Mod_1;
/*
 * Programmer Name: Implementing a Superclass Bank Account, option #1
 * Program Author: Bryan Coss Y Leon 
 * Date 12/09/2024
 * 
 * Purpose:
 * This program will imprement the parent BankAccount and child class CheckingAccount to show inheritance.
 * In this test code, i will create a 6 accounts, 3 for each and show that every part
 * I will show the getters and setters, each print function and possible errors
 * These errors will catch a negative interest rate and a negative withdrawal
 */
public class Main {


	public static void main(String[] args) {
		//Bank accounts we will use to test BankAccount 
		BankAccount bryan = new BankAccount("Bryan", "Ortega", 1157, 2002.45);
		BankAccount Monse = new BankAccount("Monserrat", "Coss", 4933, 20000.024);
		BankAccount Alexis = new BankAccount("Alexis", "Ortega", 10, 35.99);

		bryan.deposit(115.00);
		Monse.withdrawal(150.00);
		/*
		 * Here I will show the getters and setters functioning
		 */
		System.out.println("Bryan getBalance: " + bryan.getBalance());
		
		Alexis.setFirstName("alexis");
		System.out.println("Alexis setFirstName to alexis: " + Alexis.getFirstName());
		
		Alexis.setLastName("ortega");
		System.out.println("Alexis setLastName to ortega: " + Alexis.getLastName());
		
		Monse.setAccountID(4934);
		System.out.println("Monse set AccountID to 4934: " + Monse.getAccountID());
		
		//Print statements for BankAccount with a personal touch
		bryan.accountSummary();
		System.out.println();
		Alexis.accountSummary();
		System.out.println();
		Monse.accountSummary();
		System.out.println();

		//Bank accounts for CheckingAccount class
		CheckingAccount Gio = new CheckingAccount("Gio", "Aldana", 4935, 35.99, 0.02);
		CheckingAccount Gael = new CheckingAccount("Gael", "Vazquez", 4936, 150.00, 0.012);
		CheckingAccount Liam = new CheckingAccount("Liam","Vazquez", 4937, 1250.00, 0.0012);
		
		//Inherited functions
		Gio.processWithdrawal(40.00);	
		Liam.deposit(100);	
		Gael.setFirstName("GAEL");

		//Print statements for CheckingAccounts
		Liam.displayAccount();
		Gio.displayAccount();
		Gael.displayAccount();
		
		/*
		 * This try catch will catch form negative interest rates
		 */
		try{
			CheckingAccount Mateo = new CheckingAccount("Liam","Vazquez", 4937, 1250.00, -0.0012);

		} catch(IllegalArgumentException e){
			System.out.println("Error: " + e.getMessage());
		}
		/*
		 * This wikll catch a negative withdrawal
		 */
		try{
			CheckingAccount Matty = new CheckingAccount("Liam","Vazquez", 4937, 1250.00, 0.0012);
			Matty.processWithdrawal(-400);
		}catch(IllegalArgumentException e){
			System.out.println("Error: " + e.getMessage());
		}
	}

}
