package CSC372.MOD_2;

public class BankClients {
	
	public String name;
	public String userID;
	public String password;
	public double balance;
	
	
	BankClients(){
		String user = "NONE";
		String password = "NONE";
		double checking = 0.0;
		double savings = 0.0;
		String name = "Not a user";
		
	}
	
	BankClients(String name, String userID, String password, double balance){
		this.name = name;
		this.userID = userID;
		this.password = password;
		this.balance = balance;
		
		
	}
	//This will be the deposits where customer can deposit into either savings or checkings
	public void depositCheckings(double deposit) {
		this.balance =this.balance + deposit;
	}
	public void withdraw(double withd) {
		this.balance = this.balance - withd;
	}
	public double getBalance() {
		return this.balance;
	}
	public String getUserID() {
		return this.userID;
	}
	public String getPass() {
		return this.password;
	}
	public String getName() {
		return this.name;
	}
	
	
	
	
	

}
