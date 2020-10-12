package hashReadJavaFile;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JTextField;

public class App {

	private JFrame frame;
	private JButton get_file;
	private JTextField read_store_textfield;
	private JLabel lblNewLabel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
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
	public App() {
		initialize();
		setEvent();
	}
	
	/**
	 * setEvent function adds actionlistener to JButton
	 */
	public void setEvent() {
		get_file.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				create_file();
			}
		});
	}

	
	public void create_file() {
		// INTIALIZE STOPWATCH
		StopWatch watch = new StopWatch();
		try {
			// START TIME
			watch.start();
			
			// READ FILE
			ReadFile rf = new ReadFile();
			rf.readFileToHashMap();
			
			// END TIME
			watch.stop();
			// END TIME
			read_store_textfield.setText( watch.toString() );
			
			watch = new StopWatch();
			watch.start();
			// WRITE TO FILE
			WriteFile wf = new WriteFile();
			wf.hashToFile();
			watch.stop();
		
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
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
		
		get_file = new JButton("Read File");
		get_file.setFont(new Font("Tahoma", Font.BOLD, 15));
		get_file.setBounds(139, 54, 147, 51);
		panel.add(get_file);
		
		JLabel title = new JLabel("Hash Map ");
		title.setFont(new Font("Tahoma", Font.BOLD, 22));
		title.setBounds(156, 11, 123, 32);
		panel.add(title);
		
		JLabel time_lbl = new JLabel("Time in Seconds: ");
		time_lbl.setBounds(44, 193, 89, 14);
		panel.add(time_lbl);
		
		read_store_textfield = new JTextField();
		read_store_textfield.setBounds(156, 190, 195, 20);
		panel.add(read_store_textfield);
		read_store_textfield.setColumns(10);
		
		lblNewLabel = new JLabel("Time to read and Store in Hash Table");
		lblNewLabel.setBounds(156, 165, 262, 14);
		panel.add(lblNewLabel);
	}
}
