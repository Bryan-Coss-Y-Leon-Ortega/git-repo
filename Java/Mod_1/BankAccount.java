package Java.Mod_1;

/*
 * Programmer Name: Implementing a Superclass Bank Account, option #1
 * Program Author: Bryan Coss Y Leon 
 * Date 12/09/2024
 * 
 * Purpose:
 * Here is the parent BankAccount, this holds first and last name, account id, and balance.
 * This has a funtions of headers and getters, deposits, withdrawals and a print funtion for the information
 */
 public class BankAccount {

	public String firstName;
	public String lastName;
	public int accountID;
	public double balance;
	
	//Empty bank account with no name, ID or balance
	public BankAccount() {
		this.firstName = "First";
		this.lastName = "Last";
		this.accountID = 0;
		this.balance = 0.0;
	}
	
	//Constructor bank account, I will take names, account ID and a balance
	public BankAccount(String firstName, String lastName, int accountID, double balance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountID = accountID;
		this.balance = balance;
	}
	
	/*
	 * These are the deposit and withdrawals, the only functions that do arithmatic
	 */
	public void deposit(double deposit) {
		this.balance = this.balance + deposit;
	}
	public void withdrawal(double credit) {
		this.balance = this.balance - credit;
	}
	/*
	 * All the setters for first and last name and account ID
	 * Overrides the value with new value 
	 */
	public void setFirstName(String name) {
		this.firstName = name;
	}
	public void setLastName(String name) {
		this.lastName = name;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	/*
	 * All the getters for first and last name, account id and balance
	 * This will return the value
	 */
	public double getBalance() {
		return this.balance;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public int getAccountID() {
		return this.accountID;
	}
	
	/*
	 * Prints the account summary in the following format
	 * Name: First Last
	 * Account ID: ####
	 * Balance: #####.#
	 */
	public void accountSummary() {
		System.out.println("Bank of Bryan account profile: " );
		System.out.println("Name: " + firstName + " " + lastName);
		System.out.println("Account ID: "+ accountID);
		System.out.println("Balance: $" + balance);
	}
	
}
