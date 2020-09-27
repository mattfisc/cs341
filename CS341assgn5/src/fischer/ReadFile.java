package fischer;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

public class ReadFile {

	public JButton btn_open;
	public JFileChooser fc;
	
	public File file;
	public Scanner fileIn;
	public int response;
	
	private LinkedList list;
	
	public ReadFile() {
		list = new LinkedList();

		btn_open = new JButton("Open");
		fc = new JFileChooser(".");
		fc.setDialogTitle("Input File");
		
		
		readFileToList();
	}
	
	public void readFileToList() {
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		response = fc.showOpenDialog(null);
		
		if(response == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
			try {
				fileIn = new Scanner(file);
				
				if(file.isFile()) {
					while(fileIn.hasNextLine()) {
						String next = fileIn.next();
						try {
							list.addNode(Double.parseDouble(next));
							
						}
						catch(Exception e) {
							System.out.println("not double input");
						}
					}
				}
				else {
					System.out.println("that was not a file");
				}
				fileIn.close();
				
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		file = fc.getSelectedFile();
	}

	/**
	 * @return the list
	 */
	public LinkedList getList() {
		return list;
	}

	
	
	
	
}
