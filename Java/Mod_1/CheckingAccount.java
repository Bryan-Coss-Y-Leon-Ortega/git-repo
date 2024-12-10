import java.text.DecimalFormat;

public class CheckingAccount extends BankAccount {

	double interestRate = (0.04 / 12);
	int FEES = 30;
	
	public CheckingAccount() {
		
	}
	public CheckingAccount(String firstName, String lastName, int accountID, double balance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountID = accountID;
		this.balance = balance;
	}

	public void processWithdrawal(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Withdrawal must be a positive value");
		}
		else if (this.getBalance() > amount) {
			this.withdrawal(amount);
		} else if (this.getBalance() < amount) {

			System.out.println("A fee will be applied to this withdrawal");
			this.withdrawal(amount);
			this.withdrawal(FEES);
		} 

	}
	
	public void displayAccount() {
		accountSummary();
		DecimalFormat df = new DecimalFormat("#.#####");
		System.out.println("Monthly interest rate: " + df.format(interestRate));
	}

}
