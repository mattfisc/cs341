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
import java.math.BigInteger;

public class bigIntAdd {

	private JFrame frame;
	private JTextField textField_X;
	private JTextField textField_Y;
	private JTextField answer;
	private JButton btn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bigIntAdd window = new bigIntAdd();
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
	public bigIntAdd() {
		initialize();
		createEvent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel instruction = new JLabel("Enter only positive numbers");
		instruction.setFont(new Font("Tahoma", Font.BOLD, 15));
		instruction.setBounds(86, 27, 232, 31);
		frame.getContentPane().add(instruction);
		
		JLabel labelX = new JLabel("X");
		labelX.setBounds(10, 72, 46, 14);
		frame.getContentPane().add(labelX);
		
		JLabel labelY = new JLabel("Y");
		labelY.setBounds(10, 111, 46, 14);
		frame.getContentPane().add(labelY);
		
		textField_X = new JTextField();
		textField_X.setBounds(66, 69, 232, 20);
		frame.getContentPane().add(textField_X);
		textField_X.setColumns(10);
		
		textField_Y = new JTextField();
		textField_Y.setBounds(66, 108, 232, 20);
		frame.getContentPane().add(textField_Y);
		textField_Y.setColumns(10);
		
		btn = new JButton("Add");
		btn.setBounds(139, 142, 89, 23);
		frame.getContentPane().add(btn);
		
		answer = new JTextField();
		answer.setBounds(23, 181, 381, 69);
		frame.getContentPane().add(answer);
		answer.setColumns(10);
	}
	
	public void createEvent() {
		btn.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				displayOutput();
			}
		});
	}
	
	public void displayOutput() {
		// get x
		BigInteger x = new BigInteger(textField_X.getText());
		// get y
		BigInteger y = new BigInteger(textField_Y.getText());
		// get sum
		BigInteger sum = x.add(y);
		// display sum
		answer.setText(sum.toString());
	}

}
