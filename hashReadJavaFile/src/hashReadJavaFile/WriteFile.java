package hashReadJavaFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author Matthew Fischer
 * 
 *
 */
public class WriteFile {

	private FileWriter file;
	
	/**
	 * WriteFile constructor creates and writes to a file
	 */
	public WriteFile() {
		
	}
	
	/**
	 * hashToFile function write HashMap to file
	 */
	public void hashToFile() {
		
		try {
			// CREATE FILE WRITER
			file = new FileWriter("java_reserve_list.txt");
			
			// HEADER
			file.write("Keys\tand\tvalues\n");
			file.write("-----------------------------------------------\n");
			
			// PRINT KEY AND VALUE
			for (String i : Hash.map.keySet()) {
				file.write("Key:\t" + i + "\tValue:\t" + Hash.map.get(i) + "\n");
			}
			file.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
