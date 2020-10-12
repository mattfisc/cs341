package hashReadJavaFile;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

/**
 * 
 * @author Matthew Fischer
 *
 */
public class ReadFile {
      
	public JButton btn_open;
	public JFileChooser choice;
	public File file;
	public int response;
	
	
    String[] reserve = {"public","protected","private","Integer","Double","class","void","int","double","String",
    		"if","else","for","while","try","catch","do"};
    
	
	/**
	 * Constructor ReadFile
	 * 
	 * @param btn_open JButton open file selected
	 * @param choice JFileChooser class object
	 * @param file File selected to read
	 * @param reponse int is file selected
	 * @param reserve String array check for words in file
	 */
	public ReadFile() {
		btn_open = new JButton("Open");
		choice = new JFileChooser(".");
		choice.setDialogTitle("Input File");
	}
	
	/**
	 * readFileToHashMap function reads a chosen file and checks for reserved words 
	 * and stores in static HashMap and counts appearances
	 * 
	 */
	public void readFileToHashMap() {
		choice.setFileSelectionMode(JFileChooser.FILES_ONLY);
		response = choice.showOpenDialog(null);
		
		
		if(response == JFileChooser.APPROVE_OPTION) {
			file = choice.getSelectedFile();
			
			try {
				
				// RESET ON INPUT SEARCH
				Scanner fileIn = new Scanner(file);
				// IS FILE
				if(file.isFile()) {
					
					String filename = choice.getSelectedFile().getName();
					String extension = filename.substring(filename.lastIndexOf("."),filename.length());
					
					if(extension.equals(".java")) {
						while( fileIn.hasNext() ) {
							// GET DATA 
							String word = fileIn.next();
							word = word.trim();
							for(int i = 0; i < reserve.length;i++) {
								String key = reserve[i];
								if(word.contains(key)) {
									
									if(Hash.map.get(key) == null)
										Hash.map.put(key, 1);
									else
										Hash.map.put(key, Hash.map.get(key)+1);
								}
								
							}
						}// END OF READING FILE
					}
					else {
						System.out.println("Error wrong type of file.  Select a .java extension");
					}
					
					
					
				}// NOT FILE
				else {
					System.out.println("that was not a file");
				}
				
				fileIn.close();
				
			}catch(FileNotFoundException e) {
				System.out.println("error trying to read file");
				e.printStackTrace();
			}
		}
		else {
			System.out.println("file did not load");
		}
		
		file = choice.getSelectedFile();
	}


	

}




