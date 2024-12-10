
public class Main {


	public static void main(String[] args) {
		
		BankAccount bryan = new BankAccount("Bryan", "Ortega", 1157, 2002.45);
		BankAccount Monse = new BankAccount("Monserrat", "Coss", 4933, 20000.024);
		BankAccount Alexis = new BankAccount("Alexis", "Ortega", 10, 35.99);

		bryan.deposit(115.00);
		Monse.withdrawal(150.00);
		
		System.out.println("Bryan getBalance " + bryan.getBalance());
		
		Alexis.setFirstName("alexis");
		System.out.println("Alexis setFirstName to alexis: " + Alexis.getFirstName());
		
		Alexis.setLastName("ortega");
		System.out.println("Alexis setLastName to ortega: " + Alexis.getLastName());
		
		Monse.setAccountID(4934);
		System.out.println("Monse set AccountID to 4934: " + Monse.getAccountID());
		
		bryan.accountSummary();
		Alexis.accountSummary();
		Monse.accountSummary();
		
		CheckingAccount Gio = new CheckingAccount("Gio", "Aldana", 4935, 35.99);
		CheckingAccount Gael = new CheckingAccount("Gael", "Vazquez", 4936, 150.00);
		CheckingAccount Liam = new CheckingAccount("Liam","Vazquez", 4937, 1250.00);
		
		Liam.displayAccount();
		
		Gio.processWithdrawal(40.00);		
		Gio.accountSummary();
		
		Gael.processWithdrawal(-400.00);
		Gael.accountSummary();
		
	}

}
