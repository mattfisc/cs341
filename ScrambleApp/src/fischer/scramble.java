/**
* The Scramble program implements an application that
* gives all purmutaions of the characters given by the user.
* minimum number of characters is 4 and max number of characters is 7.
*
* @author  Matthew Fischer
* @version 1.0
* @since   09/06/2020 
*/

package fischer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JScrollPane;

public class scramble {

	private JFrame frame;
	private JTextField input;
	private JTextField output;
	private JButton btn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					scramble window = new scramble();
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
	public scramble() {
		initialize();
		createEvent();
	}

	/**
	 * createEvent function
	 * Adds ActionListener to a button
	 */
	private void createEvent() {
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// display output
				displayOutput();
			}
		});
	}
	/**
	 * display function
	 * @param letter_input string to read user input
	 * @param state int no errors state equals one
	 */
	private void displayOutput() {
		// GET INPUT
		String letter_input = input.getText();
		
		int state = errorCheck(letter_input);
		// CREATE ALL POSSIBLE SCABLES
		if(state == 1)
			permute(letter_input,0,letter_input.length()-1);
	}
	
	/** 
     * permutation function 
     * @param str string to calculate permutation for 
     * @param l starting index 
     * @param r end index 
     */
    private void permute(String str, int l, int r) 
    { 
        if (l == r) {
        	String output_str = output.getText();
        	output_str += "\n" + str;
            output.setText(output_str); 
        }
        else { 
            for (int i = l; i <= r; i++) { 
                str = swap(str, l, i); 
                permute(str, l + 1, r); 
                str = swap(str, l, i); 
            } 
        } 
    } 
  
    /** 
     * Swap Characters at position 
     * @param str string value 
     * @param i position 1 
     * @param j position 2 
     * @return swapped string 
     */
    public String swap(String str, int i, int j) 
    { 
        char temp; 
        char[] charArray = str.toCharArray(); 
        temp = charArray[i]; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    } 

    /** 
     * errorCheck method
     * check for max and min lengths
     * @param state int error occurred at -1
     * @param temp string holds for multiple errors
     * @return int negative means errors
     */
    public int errorCheck(String input){
    	int state = 1;
    	String temp = "";
    	
    	if(input.length() > 7) {
    		output.setText("ERROR: Too many letters.  No more than 7.");
    		state = -1;
    	}
    	if(input.length() < 4) {
    		temp = output.getText();
    		output.setText(temp +" ERROR: Too few letters.  No less than 4.");
    		state = -1;
    	}

    	// ERROR NONLETTERS
    	for(int i=0; i<input.length(); i++) {
    		if(!Character.isLetter(input.charAt(i)) ) {
        		temp = output.getText();
    			output.setText(temp +" ERROR: Only letters no symbols");
    			state = -1;
    		}
    	}
    	return state;
    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl_one = new JLabel("Enter 4 to 7 letters:");
		lbl_one.setBounds(71, 72, 109, 14);
		frame.getContentPane().add(lbl_one);
		
		input = new JTextField();
		input.setBounds(190, 69, 93, 20);
		frame.getContentPane().add(input);
		input.setColumns(10);
		
		JLabel title = new JLabel("Scramble");
		title.setFont(new Font("Tahoma", Font.BOLD, 17));
		title.setBounds(154, 24, 86, 28);
		frame.getContentPane().add(title);
		
		output = new JTextField();
		output.setBounds(10, 127, 414, 42);
		frame.getContentPane().add(output);
		output.setColumns(10);
		
		btn = new JButton("Submit");
		btn.setBounds(151, 97, 89, 23);
		frame.getContentPane().add(btn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(214, 131, 2, 2);
		frame.getContentPane().add(scrollPane);
	}
}
