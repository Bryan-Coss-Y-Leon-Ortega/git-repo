package CSC372.MOD_2;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class loginAccount extends JFrame {
	
	public loginAccount(BankClients authClient) {
		
		setTitle("Login Screen");
		setSize(600,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new GridBagLayout());
		
		// This is a welcome sign to the login.
		JLabel title = new JLabel("Welcome " + authClient.getName());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0,0,0,0);
		add(title, gbc);
		
		//This will be the balance of the current person's total
		JLabel currTotal = new JLabel("Current total: " + String.format("%.2f",authClient.balance));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(10,0,10,0);
		add(currTotal, gbc);
		
		//deposit
		JLabel deposit = new JLabel("Deposit");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(10,10,10,10);
		add(deposit, gbc);
		
		JTextField depoText = new JTextField("0.00",20);
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.insets = new Insets(10,10,10,10);
		add(depoText, gbc);
		
			
		//withdrawal
		JLabel withdraw = new JLabel("Withdraw");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.insets = new Insets(10,10,10,10);
		add(withdraw, gbc);
		
		JTextField wdText = new JTextField("0.00",20);
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.insets = new Insets(10,10,10,10);
		add(wdText, gbc);
		
		JButton action = new JButton("Enter");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.insets = new Insets(10,10,10,10);
		add(action, gbc);
		
		setVisible(true);
		
		action.addActionListener(new ActionListener() {
			@Override
        	public void actionPerformed(ActionEvent e) {
				String withd = wdText.getText();
				String depos = depoText.getText();
				
				if(!isNumeric(withd) || !isNumeric(depos)) {
					//messageLabel.setText("Error, all fields need to be numbers");
					
				}else {
					double num1 = Double.parseDouble(withd);
					double num2 = Double.parseDouble(depos);
					
					authClient.depositCheckings(num2);
					authClient.withdraw(num1);
					
					wdText.setText("0.00");
					depoText.setText("0.00");
					currTotal.setText("Current total: " + String.format("%.2f",authClient.balance));

				}
				
			}
		});
		
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
