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
import javax.swing.JTextField;

public class CreateAccount extends JFrame{
	
	public CreateAccount(ArrayList<BankClients> clientList) {
        
		setTitle("Login Screen");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new GridBagLayout());
		//GridBagConstraints gbc = new GridBagConstraints();
		
		// The label for name
		JLabel nameLabel = new JLabel("Enter Name:");
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(10,10,10,10);
		add(nameLabel, gbc);

		// Text box for the name
		JTextField nameText = new JTextField(15);
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(10,10,10,10);
		add(nameText, gbc);
		
		// label of the account ID
		JLabel acctID = new JLabel("Account ID:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(10,10,10,10);
		add(acctID, gbc);
		
		// Text box for the account ID
		JTextField acctIDTxt = new JTextField(15);
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.insets = new Insets(10,10,10,10);
		add(acctIDTxt, gbc);
		
		// Label for the password
		JLabel passLabel = new JLabel("Password:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.insets = new Insets(10,10,10,10);
		add(passLabel, gbc);
		
		// TextBox for the password
		JTextField passText = new JTextField(15);
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.insets = new Insets(10,10,10,10);
		add(passText, gbc);
		
		// This is the label for the initial deposit
		JLabel acctCheck = new JLabel("Initial deposit:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.insets = new Insets(10,10,10,10);
		add(acctCheck, gbc);
		
		// This is the text field for the initial deposit
		JTextField acctCheckNum = new JTextField(15);
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.insets = new Insets(10,10,10,10);
		add(acctCheckNum, gbc);
		
		// This is the button create the 
		JButton button = new JButton("Enter");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.insets = new Insets(10,10,10,10);
		add(button, gbc);
		
		// This will be the message label to display feedback
		JLabel messageLabel = new JLabel("");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.insets = new Insets(10,10,10,10);
		add(messageLabel, gbc);
		
		button.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String name = nameText.getText();
        		String userID = acctIDTxt.getText();
        		String passw = passText.getText();
        		String deposit = acctCheckNum.getText().trim();
        		
        		//Check if text fields are valid
        		if(name.isEmpty() || userID.isEmpty() || passw.isEmpty() || deposit.isEmpty()) {
        			// System.out.println("All fields are required.");
        			messageLabel.setText("Error: All fields are required!");
        		} else if (!isNumeric(deposit)) {
        			//System.out.println("Initial deposit must be a numeric value");
        			messageLabel.setText("Initial deposit must be a numeric value");
        		} else {
        			double num = Double.parseDouble(deposit);
        			BankClients newClient = new BankClients(name, userID, passw, num);
        			clientList.add(newClient);
        			messageLabel.setText("Client added");
        			//System.out.println("Client successfully creates.");
        			//System.out.println("Current Clients: "+ clientList.size());
        			//Clears text after the input
        			nameText.setText("");
        			acctIDTxt.setText("");
        			passText.setText("");
        			acctCheckNum.setText("");
        		}
        	}
        });

		setVisible(true);
	}

	//This method will make sure the deposited number is an integer
	protected boolean isNumeric(String num) {
		
		try {
			Double.parseDouble(num);
			return true;
		}catch (Exception e) {
			System.out.println("Exception:" + e);
			return false;
		}
	}
	//This method will make sure it is not an empty string
	public static boolean isEmpty(String str) {
		
		if(str.length() > 0) {
			return true;
		}else {
			
			return false;
		}
	}
}
