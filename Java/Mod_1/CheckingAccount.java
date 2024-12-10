package Java.Mod_1;

import java.text.DecimalFormat;

/*
 * Programmer Name: Implementing a Superclass Bank Account, option #1
 * Program Author: Bryan Coss Y Leon 
 * Date 12/09/2024
 * 
 * Purpose:
 * A checking account that will inherit functions of the BankAccount class.
 * This has an addition of a double interest rate and a different type of wothdrawal and deposit function
 */


/*
 * This will be the child to the Bank Account class
 */
public class CheckingAccount extends BankAccount {

	double interestRate;
	double FEES = 30;
	boolean check = false;
	
	public CheckingAccount() {
		super();
		interestRate = 0.001;
	}
	/*
	 * This is the checking account constructor class
	 * Similar to the bank account, need an interest rate attribute
	 */
	public CheckingAccount(String firstName, String lastName, int accountID, double balance, double interestRate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountID = accountID;
		this.balance = balance;
		if(interestRate < 0){
			throw new IllegalArgumentException("Interest rate cannot be negative.");
		}
		this.interestRate = interestRate;
	}

	/*
	 * This will process the withdrawal from the checking account
	 * If it is less than 0, throw an error,
	 * if it is more than the account amount, withdrawal
	 * if it is more than the account amount, there is a fee and then withdrawal
	 */
	public void processWithdrawal(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Withdrawal must be a positive value");
		}
		else if (this.getBalance() > amount) {
			this.withdrawal(amount);
		} else if (this.getBalance() < amount) {

			System.out.println("A fee of $30 will be applied to this account");
			this.withdrawal(amount);
			this.withdrawal(FEES);
		} 

	}
	/*
	 * THis will display the account amount to the user
	 */
	public void displayAccount() {
		accountSummary();
		DecimalFormat df = new DecimalFormat("#.#####");
		System.out.println("Monthly interest rate: " + df.format(interestRate) + "\n");
	}

}
