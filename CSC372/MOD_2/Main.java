package CSC372.MOD_2;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
	

    public static void main(String[] args){
    	ArrayList<BankClients> clientList = new ArrayList<BankClients>();
    	
        /*
         * This will be the frame for the bank screen
         * This will have the title, size, set visible and close
         */
        JFrame bankFrame = new JFrame();
        bankFrame.setTitle("Bank of Bryan");
        bankFrame.setSize(800,700);
        
        /*
         * The clients will be held in an array list
         * */
        
        
        
        /*
         * Start of the operation,
         * Needs:
         * 			[Bank of Bryan title]
         * 
         * "Username" [Text Box to enter username]
         * "Password" [Text box to enter password]
         * 				Button[Login]
         * 				Button[Create Account]
         * 
         * Results of login:
         * 
         * */

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        //gbc.insets = new Insets(10, 10, 10, 10); // Padding between components
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // This is the label of Bryan's Bank
        JLabel title = new JLabel("Welcome to Bryan's Bank");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(40,5,40,5);
        panel.add(title, gbc);
        
        // This is the user name label
        JLabel login = new JLabel("Username: ");
        gbc.insets = new Insets(5,5,5,1);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(login, gbc);

        //This is the username text field
        JTextField loginField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(loginField, gbc);
        
        // This is the password txt
        JLabel pass = new JLabel("Password: ");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(pass, gbc);
        
        // This is th password text field
        JTextField passField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(passField, gbc);
        
        // This is the button
        JButton button = new JButton("Login");
        gbc.insets = new Insets(40,10,0,10);
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(button, gbc);
        
        // This is the create account button
        JButton createAcct = new JButton("Create account");
        gbc.insets = new Insets(10,10,10,10);
        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(createAcct, gbc);
        
        //this will be the action for the login
        button.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String username = loginField.getText().trim();
        		String password = passField.getText().trim();
        		
        		//credential checks
        		BankClients authClient = Authenticate(username, password, clientList);
        		
        		if(authClient != null) {
        			System.out.print("Correct person");
        			new loginAccount(authClient);
        			
        		}else {
        			//messageLabel.setText("Incorrect username or password");
        			System.out.println("Incorrect username or password");
        		}
        	}
        });

        //This will be the button to create a new client in the Bryan Bank inventory
        createAcct.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		new CreateAccount(clientList);

        	}
        });
        
        // Frame stuff, needed
        bankFrame.add(panel);
        bankFrame.setVisible(true);
        bankFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //These are the test clients that will be added to the inventory
        BankClients bryan = new BankClients("Bryan Coss Y Leon", "ABCD1234", "EFG1234", 200.00);
    	BankClients Monse = new BankClients("Monse Coss Y Leon", "asd123", "EFG1234", 200.00);
    	BankClients Alexis = new BankClients("Alexis Coss Y Leon", "qwerty", "EFG1234", 200.00);
    	BankClients Oscar = new BankClients("Oscar Coss Y Leon", "123458", "EFG1234", 200.00);
    	BankClients Bere = new BankClients("Bere Aldana", "bears", "EFG1234", 200.00);
    	BankClients Eman = new BankClients("Eman busty", "ABCD1234", "EFG1234", 200.00);
    	
    	//Preloaded clients to the bank list
    	clientList.add(bryan);
    	clientList.add(Monse);
    	clientList.add(Alexis);
    	clientList.add(Oscar);
    	clientList.add(Bere);
    	clientList.add(Eman);  	

    }
    
    //This is a user authentication 
    private static BankClients Authenticate(String username, String password, ArrayList<BankClients> clientList) {
		for(BankClients client : clientList) {
			if(client.getUserID().equals(username) && client.getPass().equals(password)) {
				return client;
			}
		}
		return null;
	}
}