package Java.Mod_1;


public class BankAccount {

	public String firstName;
	public String lastName;
	public int accountID;
	public double balance;
	
	public BankAccount() {
		this.firstName = "First";
		this.lastName = "Last";
		this.accountID = 0;
		this.balance = 0.0;
	}
	
	public BankAccount(String firstName, String lastName, int accountID, double balance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountID = accountID;
		this.balance = balance;
	}
	
	public void deposit(double deposit) {
		this.balance = this.balance + deposit;
	}
	public void withdrawal(double credit) {
		this.balance = this.balance - credit;
	}
	public double getBalance() {
		return this.balance;
	}
	public void setFirstName(String name) {
		this.firstName = name;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public void setLastName(String name) {
		this.lastName = name;
	}
	public String getLastName() {
		return this.lastName;
	}
	public int getAccountID() {
		return this.accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public void accountSummary() {
		System.out.println("Name: " + firstName + " " + lastName);
		System.out.println("Account ID: "+ accountID);
		System.out.println("Balance: " + balance);
	}
	
}
