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
	private FileReader fr;
	private String file_name;
	
	/**
	 * WriteFile constructor creates and writes to a file
	 */
	public WriteFile() {
		file_name = "list.txt";
	}
	
	/**
	 * hashToFile function write HashMap to file
	 */
	public void write_to_file() {
		
		try {
			// CREATE FILE WRITER
			fw = new FileWriter(file_name);
			
			// READ LIST TO FILE
			for(int i = 0; i < BookList.booklist.size(); i++) {
				fw.append(BookList.booklist.get(i).getSku() + " " +
						BookList.booklist.get(i).getTitle() + " " +
						BookList.booklist.get(i).getPrice() + " " +
						BookList.booklist.get(i).getQuantity()
						);
			}
			
			fw.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public String read_from_file() {
		String str = "";
			try {
				// CREATE FILE WRITER
				fr= new FileReader(file_name);
				Scanner input = new Scanner(fr);
				
				// READ TO A STRING
				while(input.hasNext()) {
					str += input;
				}
				
				fw.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			return str;
		}
	
}
