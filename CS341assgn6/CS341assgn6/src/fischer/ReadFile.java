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
 * 
 * class ReadFile
 * @param t Token is the token of the next token read from file
 * @param parse Parser class that compiles Tokens
 * @param btn_open JButton click to upload a file
 * @param fc FJileChooser class that uploads a file
 * @param file File class creates a file to read
 * @param response int stores if JFileChooser is responding
 * @param totalcount int stores number of lines of code
 * @param func_list LinkedList storage for all function names
 * @param construct_list LinkedList storage for all control structures
 * @param row int is the row of code
 */
public class ReadFile {
      
    public Parser parse;
	public JButton btn_open;
	public JFileChooser fc;
	public File file;

	public int response;
    public int totalcount;
    
    public LinkedList class_list;
    public LinkedList function_list;
    public LinkedList construct_list;
    
    
    String[] class_reserve = {"public","class"};
	String[] class_method = {"public","void","int","double","String"};
	String[] control_structure = {"if","else","for","while","try","catch","do"};
    
	
	/**
	 * Constructor ReadFile
	 * 
	 */
	public ReadFile() {
		totalcount = 0;
		
		class_list = new LinkedList();
		function_list = new LinkedList();
		construct_list = new LinkedList();
		
		
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
				
				// RESET ON INPUT SEARCH
				Scanner fileIn = new Scanner(file);
				function_list = new LinkedList();
				construct_list = new LinkedList();
				totalcount = 0;
				
				// IS FILE
				if(file.isFile()) {
					
					while( fileIn.hasNextLine() ) {
						// GET DATA 
						String line = fileIn.nextLine();
						line = line.trim();
						
						// NOT EMPTY LINE
						if( !line.isEmpty() ) {
							int count = 0;
							
							// FIND COMMENT
							if(line.contains("//")) {
								
								// COMMENT IN QUOTES
								if(line.contains("\"")) {
									count = commentcount(line,'\"');
								}
								else if(line.contains("\'")) {
									count = commentcount(line,'\'');
								}
							}
							// MULTILINE
							else if(line.contains("/*")) {
								
								// COMMENT IN QUOTES
								if(line.contains("\"")) {
									count = commentcount(line,'\"');
								}
								else if(line.contains("\'")) {
									count = commentcount(line,'\'');
								}
								// FIND END OF MULTILINE COMMENT
								while(!line.contains("*/")) {
									line = fileIn.nextLine();
								}
							}
							// CODE LINE
							else {
								count = 1;
							}
							
							if(count > 0) {
								totalcount += count;
								// CODE LINE
								method_class_check(line);
								control_check(line);
							}
							
						}

						
						
					}// END OF READING FILE
					
					
				}// NOT FILE
				else {
					System.out.println("that was not a file");
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
	 * commentcount function count if line has any code in the comment line
	 * @param line String of file line 
	 * @param ch is the double or single quote
	 * @return 0 or 1 if comment is in quotes
	 */
	public int commentcount(String line,char ch) {
		for(int i = 0; i < line.length();i++) {
			int quote = line.indexOf("\"");
			int comment = line.indexOf("/");
			
			// COMMENT IN STING
			if(quote < comment)
				return 1;
		}
		return 0;
	}
	
	/**
	 * method_class_check function checks if the code is a method or class name and adds name to LinkedList
	 * @param line String is a file line
	 */
	public void method_class_check(String line) {
		try {
			Scanner get_word = new Scanner(line);
			if(get_word.hasNext()) {
				String word = get_word.next();
				if(get_word.hasNext() && word.equals("public")) {
					word = get_word.next();
					if(get_word.hasNext() && !word.equals("class")) {
						word = get_word.next();
						// GET ONLY METHOD NAME
						int paren = word.indexOf('(');
						if(paren < word.length());
							word = word.substring(0, paren);
						
						// FOUND NAME
						Node temp = (function_list.findNode(word));
						if(temp == null)
							function_list.addNode(word);
						else {
							temp.setCount(temp.getCount()+1);
						}
					}
					//CLASS
					else {
						word = get_word.next();
						
						// GET ONLY CLASS NAME
						int paren = word.indexOf('(');
						word = word.substring(0, paren);
						
						// FOUND NAME
						Node temp = (class_list.findNode(word));
						if(temp == null)
							class_list.addNode(word);
						else {
							temp.setCount(temp.getCount()+1);
						}
					}
				}
			}
		}
		catch(Exception e){
			// print error
		}
		
		
		
	}
	
	/**
	 * control_check function checks if the code is a control structure name and adds name to LinkedList
	 * @param line String is a file line
	 */
	public void control_check(String line) {
		try {
			// LINE

			for(int i = 0; i < control_structure.length;i++) {
				if(line.contains(control_structure[i])) {
					
					// FOUND NAME
					Node temp = (construct_list.findNode(control_structure[i]));
					if(temp == null)
						construct_list.addNode(control_structure[i]);
					else {
						temp.setCount(temp.getCount()+1);
					}
					
				}
				
			}
			
		}
		catch(Exception e) {
			// error
		}
		
	}
	

}




