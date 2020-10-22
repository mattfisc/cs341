package fischer;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 
 * @author Matthew Fischer
 * 
 *
 */
public class WriteFile {

	private FileWriter fw;
	private File file;
	private String file_name;
	
	public WriteFile() {
		file_name = "list.txt";
	}
	
	/**
	 * write_to_file function use BookList and writes values to a file
	 */
	public void write_to_file() {
		
		try {
			// CREATE FILE WRITER
			fw = new FileWriter(file_name);
			
			// READ LIST TO FILE
			for(int i = 0; i < BookList.booklist.size(); i++) { 
				fw.write( BookList.booklist.get(i).getSku() + " " +
						BookList.booklist.get(i).getTitle() + " " +
						BookList.booklist.get(i).getPrice() + " " +
						BookList.booklist.get(i).getQuantity() + "\n"
						);
			}
			fw.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * read_from_file function reads file and stores in a LinkedList BookList.booklist
	 */
	public void read_from_file() {
		
			try {
				// CREATE FILE WRITER
				file = new File(file_name);
				Scanner input = new Scanner(file);
				
				// READ TO A STRING
				while(input.hasNextLine() && file.exists()) {
					
					String line = input.nextLine();
					Scanner book_reader = new Scanner(line);
				
					// verify all attributes
					try {
						int sku = book_reader.nextInt();
						String title = book_reader.next();
						double price = book_reader.nextDouble();
						int quantity = book_reader.nextInt();
						
						// create book
						Book book = new Book(sku,title,price);
						book.setQuantity(quantity);
						
						BookList.booklist.add(book);
					}catch(Exception err) {
						err.printStackTrace();
					}
				}

			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
}
