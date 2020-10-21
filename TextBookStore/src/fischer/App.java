package fischer;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import java.awt.Panel;

public class App {

	private JFrame frame;
	
	private JTextField search_input;
	
	private ButtonGroup group;
	
	private JRadioButton radiobtn0;
	private JRadioButton radiobtn1;
	private JRadioButton radiobtn2;
	private JRadioButton radiobtn3;

	private JButton delete_btn;
	
	private JButton add_btn;
	private JTextArea display;
	private JButton search_btn;

	private WriteFile file;
	
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
		load_list();
		add_event();
		delete_event();
		radio_btn_event();
		search_event();
	}
	
	public void load_list() {
		
		String load_list = file.read_from_file();
		if(load_list.equals("")) 
			display.setText("List is empty");
		else
			display.setText(load_list);
	}
	
	public void save_list() {
		file.write_to_file();
	}
	
	
	public void search_event() {
		search_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!search_input.getText().equals("")) {
					String num_str = search_input.getText();
					int num = 0;
					
					try {
						num = Integer.parseInt( num_str );
						Book temp = BookList.get_book_by_sku(num);
						display.setText(temp.toString());
					}catch(Exception err) {
						err.printStackTrace();
					}
					
				}
						
				
				search_input.setText("");
				
			}
			
		});
	}
	public void radio_btn_event() {
		radiobtn0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String sku_str = search_input.getText();
				int sku = 0;
				try {
					// GET INPUT
					sku = Integer.parseInt(sku_str);
					
					// FIND SKU
					Book found = BookList.get_book_by_sku(sku);
					
					// DISPLAY SKU
					if(found == null)
						display.setText("Does not Exist");
					else
						display.setText(found.toString() );
					
				}
				catch(Exception err) {
					err.printStackTrace();
				}
				
				
				
			}
			
		});
		radiobtn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BookList.sort_title();
				display_list();
				
			}
			
		});
		radiobtn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BookList.sort_price();
				display_list();
				
			}
			
		});
		radiobtn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BookList.sort_quantity();
				display_list();
				
			}
			
		});
		
	}
	

	
	public void delete_event() {
		delete_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String sku_str = JOptionPane.showInputDialog("Delete Book: by SKU");
				int sku = Integer.parseInt(sku_str);
				Book temp = BookList.remove_book_by_sku(sku);
				
				if(temp == null) {
					System.out.println("Book does not exist");
				}
				else {
					System.out.println(temp.getSku() + " Book removed");
				}
				// DISPLAY CHANGE
				display_list();
			}
			
		});
	}

	public void display_list() {
		display.setText("SKU   Title   Price   Quantity");
		for(int i = 0; i < BookList.booklist.size(); i++) {
			display.setText(display.getText() + 
					"\n" + BookList.booklist.get(i).getSku() +
					"   " + BookList.booklist.get(i).getTitle() +
					"   " + BookList.booklist.get(i).getPrice() +
					"   " + BookList.booklist.get(i).getQuantity()
					);
		}
	}
	public void add_event() {
		add_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// GET SKU
				String sku_str = JOptionPane.showInputDialog("Add SKU");
				String title = "";
				String price_str = "";
				
				if(sku_str != null) {
					title = JOptionPane.showInputDialog("Add Title");
					if(title != null)
						price_str = JOptionPane.showInputDialog("Add Price");
				}
				
				int sku = 0;
				double price = 0;
				Book book = null;
				
				// FIELDS FILLED OUT
				if(sku_str != null && !title.equals("") && price_str != null) {
					try {
						sku = Integer.parseInt(sku_str);
						price = Double.parseDouble(price_str);
						book = new Book(sku,title,price);
					}
					catch(Exception err) {
						JOptionPane.showMessageDialog(null,"Error input field error.\nSKU must be an integer " + sku_str + "\nPrice must be a double or integer " + price_str);
						//err.printStackTrace();
					}
				}
								
				// ADD BOOK
				if(book != null) {
					// ADD LIST
					if(BookList.get_book_by_sku(sku) == null)
						BookList.booklist.add(book);
					else {
						BookList.incrementQuantity(sku);
						JOptionPane.showMessageDialog(null, sku + " SKU already created.  Quantity increased");
					}
				}
				// DISPLAY LIST
				display_list();
				// SAVE LIST
				save_list();
				
			}
			
		});
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		file = new WriteFile();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel title = new JLabel("Text Book Store");
		title.setBounds(118, 5, 198, 31);
		title.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(title);
		
		JLabel lbl_txtbooklist = new JLabel("Text Book List");
		lbl_txtbooklist.setBounds(300, 47, 124, 14);
		panel.add(lbl_txtbooklist);
		
		
		
		radiobtn0 = new JRadioButton("SKU");
		radiobtn0.setBounds(102, 95, 67, 23);
		panel.add(radiobtn0);
		
		radiobtn1 = new JRadioButton("Title");
		radiobtn1.setBounds(102, 121, 67, 23);
		panel.add(radiobtn1);
		
		radiobtn2 = new JRadioButton("Price");
		radiobtn2.setBounds(102, 149, 67, 23);
		panel.add(radiobtn2);
		
		radiobtn3 = new JRadioButton("Quantity");
		radiobtn3.setBounds(102, 175, 67, 23);
		panel.add(radiobtn3);

		group = new ButtonGroup();
		group.add(radiobtn0);
		group.add(radiobtn1);
		group.add(radiobtn2);
		group.add(radiobtn3);
		
		
		JLabel sort_lbl = new JLabel("Sort By:");
		sort_lbl.setBounds(102, 71, 46, 14);
		panel.add(sort_lbl);
		
		search_input = new JTextField();
		search_input.setBounds(10, 96, 86, 20);
		panel.add(search_input);
		search_input.setColumns(10);
		
		add_btn = new JButton("Add Book");
		add_btn.setBounds(7, 227, 89, 23);
		panel.add(add_btn);
		
		display = new JTextArea();
		display.setBounds(174, 72, 250, 178);
		panel.add(display);
		
		delete_btn = new JButton("Delete Book");
		delete_btn.setBounds(7, 193, 89, 23);
		panel.add(delete_btn);
		
		JLabel sku_lbl = new JLabel("Search by SKU:");
		sku_lbl.setFont(new Font("Tahoma", Font.PLAIN, 8));
		sku_lbl.setBounds(10, 78, 67, 14);
		panel.add(sku_lbl);
		
		search_btn = new JButton("Search");
		search_btn.setFont(new Font("Tahoma", Font.PLAIN, 9));
		search_btn.setBounds(7, 121, 70, 23);
		panel.add(search_btn);
		
		center(frame);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	public static void center(JFrame frame) {
		 
        // get the size of the screen, on systems with multiple displays,
        // the primary display is used
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
 
        // calculate the new location of the window
        int w = frame.getSize().width;
        int h = frame.getSize().height;
 
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;
 
        // moves this component to a new location, the top-left corner of
        // the new location is specified by the x and y
        // parameters in the coordinate space of this component's parent
        frame.setLocation(x, y);
 
    }
}
