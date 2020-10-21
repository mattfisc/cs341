package fischer;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

/**
 * 
 * @author Matthew Fischer
 *
 */
public class CodeLineCount {

	private JFrame frame;
	private JTextField totalCount;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextArea functionOutput;
	private JTextArea contrlOutput;
	private JButton btnUpload;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CodeLineCount window = new CodeLineCount();
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
	public CodeLineCount() {
		initialize();
		btn_action();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel title = new JLabel("Code Line Counter");
		title.setBounds(96, 5, 190, 26);
		title.setFont(new Font("Tahoma", Font.BOLD, 21));
		panel.add(title);
		
		JLabel FileCodeCountTitle = new JLabel("Lines of Code: ");
		FileCodeCountTitle.setBounds(195, 42, 106, 14);
		panel.add(FileCodeCountTitle);
		
		btnUpload = new JButton("Upload File");
		btnUpload.setBounds(38, 38, 89, 23);
		panel.add(btnUpload);
		
		JLabel functionTitle = new JLabel("List Functions: ");
		functionTitle.setBounds(197, 101, 117, 14);
		panel.add(functionTitle);
		
		JLabel ConStruTitle = new JLabel("List Control Structures:");
		ConStruTitle.setBounds(6, 101, 156, 14);
		panel.add(ConStruTitle);
		
		totalCount = new JTextField();
		totalCount.setBounds(311, 39, 86, 20);
		panel.add(totalCount);
		totalCount.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(6, 126, 138, 120);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(197, 126, 200, 120);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		contrlOutput = new JTextArea();
		contrlOutput.setBounds(6, 126, 138, 124);
		panel.add(contrlOutput);
		
		functionOutput = new JTextArea();
		functionOutput.setBounds(197, 126, 200, 120);
		panel.add(functionOutput);
	}


/**
 * btn_action function adds actionlistener to button
 */
	public void btn_action() {
		btnUpload.addActionListener(new ActionListener() {
	
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
		functionOutput.setText("");
		contrlOutput.setText("");
		
		ReadFile rf = new ReadFile();
		
		try {
			rf.readFileToList();
			totalCount.setText( "" + rf.totalcount );

			
			//classOutput.setText(rf.class_list.toString());
			if(rf.function_list.size() > 0)
				functionOutput.setText(rf.function_list.toString());
			if(rf.construct_list.size() > 0)
				contrlOutput.setText(rf.construct_list.toString());
			
			rf.construct_list.print_list();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error with file");
		}
		
		
		
		
		
		
	
	}
}