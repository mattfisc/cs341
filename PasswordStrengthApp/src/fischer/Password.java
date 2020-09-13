/**
* The Password program implements an application that
* checks the quality of a password by the repetitions 
* of same characters
*
** GITHUB URL https://github.com/mattfisc/cs341
* @author  Matthew Fischer
* @version 1.0
* @since   09/06/2020 
*/
package fischer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

public class Password {

	private JFrame frame;
	private JTextField password;
	private JButton submit;
	private JTextArea display;
	private JLabel lblNewLabel;
	private JLabel lbl_password;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Password window = new Password();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Password() {
		initialize();
		createEvent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 582, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lbl_password = new JLabel("Enter a password:");
		lbl_password.setBounds(35, 94, 94, 14);
		frame.getContentPane().add(lbl_password);
		
		password = new JTextField();
		password.setBounds(139, 91, 146, 20);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
		submit = new JButton("Submit");
		submit.setBounds(295, 90, 88, 23);
		frame.getContentPane().add(submit);
		
		lblNewLabel = new JLabel("Check Password Strength");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(126, 11, 244, 32);
		frame.getContentPane().add(lblNewLabel);
		
		display = new JTextArea();
		display.setBounds(115, 143, 300, 89);
		frame.getContentPane().add(display);
	}
	/** 
	 * createEvent method
	 * add actionlistener to jbutton
	 */
	public void createEvent() {
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				passwordCheck();
				
			}
			
		});
	}
	
	/**
	 * passwordCheck method
	 * @param max_block int stores longest block sequence
	 * @param block int stores block
	 */
	public void passwordCheck(){
		
		int max_block = 0;
		int block = 1;
		
		// GET PASSWORD
		String pass = password.getText();
		char[] arr = pass.toCharArray();
		
		// CHECK PASSWORD REPEAT STRENGTH
		for(int i = 0; i < arr.length-1; i++) {
			if(arr[i]==arr[i+1]) {
				block++;
				if(max_block < block)
					max_block = block;
			}else
				block = 1;
		}
		
		// ERROR PASSWORD SPACE
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == ' ')
				display.setText("ERROR No spaces in password.\n");
		}
		
		// ERROR MIN AND MAX OF PASSWORD 
		if(arr.length < 8)
			display.setText(display.getText() +"ERROR Need at least 8 characters.\n");

		if(arr.length > 12)
			display.setText(display.getText() +"ERROR No more that 12 characters.\n");
		
		// Password Character repetitions
		display.setText(display.getText() + "The largest block in the password is " + max_block + ".  \n");
		if(max_block < 2)
			display.setText(display.getText() + "This password is decent password.\n");
		else 
			display.setText(display.getText() + "This password is weak.\nThis password strength would be better if \n you take out " + (max_block-2) + "repeating characters.");
			
	}
		
		
}
