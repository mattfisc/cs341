package fischer;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * 
 * @author Matthew Fischer
 *
 */
public class ReadFile {

	public JButton btn_open;
	public JFileChooser fc;
	
	public File file;
	public Scanner fileIn;
	public int response;
	
	private LinkedList list;
	
	/**
	 * 
	 */
	public ReadFile() {
		list = new LinkedList();

		btn_open = new JButton("Open");
		fc = new JFileChooser(".");
		fc.setDialogTitle("Input File");
		
		
	}
	
	/**
	 * readFileToList function reads a chosen file and adds to a linked list.
	 * 
	 */
	public void readFileToList() {
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		response = fc.showOpenDialog(null);

		
		if(response == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
			
			try {
				
				fileIn = new Scanner(file);
				
				if(file.length() != 0) {
					System.out.println("File is empty");
					if(file.isFile()) {
						
						while(fileIn.hasNext()) {
							String num = fileIn.next();
							try {
								list.addNode(Double.parseDouble( num ));
							}
							catch(Exception e) {
								e.printStackTrace();
							}
						}
					}
					else {
						System.out.println("that was not a file");
					}
				}
			
				fileIn.close();
				
			}catch(FileNotFoundException e) {
				System.out.println("error trying to read file");
				//e.printStackTrace();
			}
		}
		else {
			System.out.println("file did not load");
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
