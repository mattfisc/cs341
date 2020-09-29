package fischer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

/**
 * This application reads a file of real numbers and gathers them into a linked list.  
 * Then returns a mean and a standard deviation.
 * 
 * @author Matthew Fischer
 * @version 1
 * @since 9/27/2020
 */
public class GuiFileReader {
	final JFileChooser fc = new JFileChooser();

	private JFrame frame;
	private JTextField textField_mean;
	private JTextField textField_sd;
	private JButton btn_upload_file;
	
	LinkedList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiFileReader window = new GuiFileReader();
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
	public GuiFileReader() {
		initialize();
		btn_action();
	}

	public void btn_action() {
		btn_upload_file.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				uploadFile();
				
			}
			
		});
	}
	
	/**
	 * uploadFile function on action listener click event upload file
	 * 
	 * @param rf ReadFile class creates object that reads a file and stores a LinkedList of real number values
	 * @param mean_num String stores a string of a real number of the mean of the values in the LinkedList
	 * @param standardDeviation_num String stores the string of a real number of the standard deviation of 
	 * the values of the LinkedList
	 */
	public void uploadFile() {
		// RESET DISPLAY FILEDS ON UPLOAD CLICK
		textField_mean.setText("");
		textField_sd.setText("");
		String mean_num= "";
		
		
		ReadFile rf = new ReadFile();
		
		try {
			rf.readFileToList();
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error with file");
		}
		
		
		list = rf.getList();
		
		// Empty file
		if(list.getHead() == null) {
			textField_mean.setText("file was empty");
			
		}
	
		// CALCULATE MEAN
		mean_num = list.get_mean();
		
		// CALCULATE SD
		String standardDeviation_num = list.get_standard_deviation(Double.parseDouble(mean_num));
		// DISPLAY BOTH
		textField_mean.setText(mean_num);
		textField_sd.setText(standardDeviation_num);
		
		
		
	
	}
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_main = new JPanel();
		panel_main.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel_main);
		panel_main.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("File Reader");
		lblNewLabel.setBounds(137, 11, 146, 32);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		panel_main.add(lblNewLabel);
		
		textField_mean = new JTextField();
		textField_mean.setBounds(181, 93, 215, 20);
		panel_main.add(textField_mean);
		textField_mean.setColumns(10);
		
		JLabel lbl_mean = new JLabel("Mean");
		lbl_mean.setBounds(129, 96, 42, 14);
		panel_main.add(lbl_mean);
		
		textField_sd = new JTextField();
		textField_sd.setBounds(181, 124, 215, 20);
		panel_main.add(textField_sd);
		textField_sd.setColumns(10);
		
		JLabel lbl_sd = new JLabel("Standard Deviation");
		lbl_sd.setBounds(65, 127, 106, 14);
		panel_main.add(lbl_sd);
		
		btn_upload_file = new JButton("Upload File");
		btn_upload_file.setBounds(25, 56, 120, 23);
		panel_main.add(btn_upload_file);
		
		list = new LinkedList();
	}
}