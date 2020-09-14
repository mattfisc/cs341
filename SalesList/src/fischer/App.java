/**
* The SalesList is an Application to add Items on a SalesList. 
*
** GITHUB URL https://github.com/mattfisc/cs341.git
* 
* @author  Matthew Fischer
* @version 1.0
* @since   09/13/2020 
*/

package fischer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;

public class App {

	private JFrame frame;
	private JTextField name_input;
	private JTextField cost_input;
	private JTextField quantity_input;
	private JButton add_btn;
	private SalesList list;
	private JTextField total_output;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 * 
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
		list = new SalesList();
		initialize();
		create_event();
		
	}

	/**
	 * Create Event add Action Listener on btn
	 * 
	 * @param e ActionEvent add ActionListener to button
	 */
	private void create_event() {
		add_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ADD ITEMS
				add_item_to_list();
				// CLEAR TEXT FIELDS
				name_input.setText("");
				cost_input.setText("");
				quantity_input.setText("");
			}
			
		});
		
	}
	
	/**
	 * add_item_to_list method gets input values and validates input, then creates a new Item object and Displays values
	 * 
	 * @param item_name String gets textfield item name input
	 * @param item_cost double gets textfield item cost input
	 * @param item_quantity int gets textfield item quantity input
	 * 
	 */
	public void add_item_to_list() {
		// DECLARE VARIABLES
		String item_name = "";
		double item_cost = 0.0;
		int item_quantity = 0;

		
		// RESET LIST AND ERROR MESSAGES
		textArea.setText("");
		
		// GET ITEM NAME AND VALIDATE
		item_name = name_input.getText();
		item_name = validate_string(item_name);
		if(item_name == null) 
			textArea.setText(textArea.getText() + "\nName Error. No numbers or symbols");

		
		// GET ITEM COST AND VALIDATE
		try {
			item_cost = Double.parseDouble( cost_input.getText() );
		}catch(Exception e){
			item_cost = 0.0;
			textArea.setText(textArea.getText() + "\nCost Error. This is not a number");
		}
		
		
		// GET ITEM QUANTITY AND VALIDATE
		try {
			item_quantity = Integer.parseInt( quantity_input.getText() );
		}catch(Exception e) {
			item_quantity = 0;
			textArea.setText(textArea.getText() + "\nQuantity Error is not a valid number.  No Decimals.");
		}
		
		
		// ADD ITEM TO LIST AND DISPLAY IF VALID VALUES
		if(item_name != null && item_cost != 0.0 && item_quantity != 0) {
			// CREAT
			list.addItem(new Item(item_name,item_cost,item_quantity));
			
			// DISPLAY ITEM
			output_list();
		}
		
	}
	

	/**
	 * add_item_to_list method creates a new Item object from user input and adds to SalesList Object
	 * 
	 * @param item_name String is user input
	 * @param valid boolean remains true if string is only letters
	 * @return valid string with only letters or null
	 * 
	 */
	private String validate_string(String item_name) {
		boolean valid = true;
		for(int i = 0; i < item_name.length(); i++) {
			if(!Character.isLetter(item_name.charAt(i)))
				valid = false;
		}
		
		if(valid)
			return item_name;
		return null;
	}

	/**
	 * output_list method
	 * Displays SalesList output
	 * 
	 * @param num NumberFormat Currency Instance
	 */
	public void output_list() {
		// DISPLAY LIST
		textArea.setText(list.toString());
		// DISPLAY TOTAL
		NumberFormat num = NumberFormat.getCurrencyInstance(Locale.US); 
		total_output.setText( num.format( list.getTotal() ) );
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel item_lbl = new JLabel("Item:");
		item_lbl.setBounds(35, 54, 58, 14);
		panel.add(item_lbl);
		
		JLabel cost_lbl = new JLabel("Cost:$");
		cost_lbl.setBounds(35, 79, 58, 14);
		panel.add(cost_lbl);
		
		JLabel quantity_lbl = new JLabel("Quantity: ");
		quantity_lbl.setBounds(35, 104, 60, 14);
		panel.add(quantity_lbl);
		
		name_input = new JTextField();
		name_input.setBounds(91, 51, 133, 20);
		panel.add(name_input);
		name_input.setColumns(10);
		
		cost_input = new JTextField();
		cost_input.setBounds(91, 76, 67, 20);
		panel.add(cost_input);
		cost_input.setColumns(10);
		
		quantity_input = new JTextField();
		quantity_input.setBounds(91, 101, 67, 20);
		panel.add(quantity_input);
		quantity_input.setColumns(10);
		
		add_btn = new JButton("Add Item to the Sales list");
		add_btn.setBounds(91, 129, 179, 23);
		panel.add(add_btn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(0, 0, 434, 43);
		panel.add(panel_1);
		
		JLabel title_str = new JLabel("Sales List");
		panel_1.add(title_str);
		title_str.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel total_lbl = new JLabel("Total: ");
		total_lbl.setBounds(134, 236, 46, 14);
		panel.add(total_lbl);
		
		total_output = new JTextField();
		total_output.setBounds(171, 233, 86, 20);
		panel.add(total_output);
		total_output.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 163, 271, 62);
		panel.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
}
