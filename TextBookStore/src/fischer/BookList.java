package fischer;
import java.util.LinkedList;

public class BookList {

	
	public static LinkedList<Book> booklist = new LinkedList<Book>();
	
	
	/**
	 * get_book_by_sku function search list by parameter int
	 * @param num int is input sku to search
	 * @return Book found or null
	 */
	public static Book get_book_by_sku(int num) {
		for(int i = 0; i < booklist.size(); i++) {
			if(booklist.get(i).getSku() == num) {
				return booklist.get(i);
			}
		
		}
		return null;
	}
	

	/**
	 * remove_book_by_sku function remove book from list by sku param
	 * 
	 * @param num int input sku search param to search list by
	 * @return Book found and delete or minus 1 quantity or null if not in list
	 */
	public static Book remove_book_by_sku(int num) {
		for(int i = 0; i < booklist.size(); i++) {
			if(booklist.get(i).getSku() == num) {
				// SUBTRACT ONE BOOK FROM QUANTITY
				if(booklist.get(i).getQuantity() > 1) {
					booklist.get(i).setQuantity( booklist.get(i).getQuantity()-1 );
					return booklist.get(i);
				// REMOVE FROM LIST
				}else {
					return booklist.remove(i);
				}
			}
		
		}
		return null;
	}
	
	/**
	 * sort_sku function sort BookList by sku from least to greatest
	 */
	public static void sort_sku() {
		for(int i = 0; i < booklist.size()-1; i++) {
			if(booklist.get(i).getSku() > booklist.get(i+1).getSku()) {
				Book temp = booklist.get(i);
				booklist.set(i, booklist.get(i+1));
				booklist.set(i+1, temp);
				i=-1;
			}
		
		}
	
	}
	
	/**
	 * sort_title function sort title alphabetically
	 */
	public static void sort_title() {
		int chIndex = 0;
		for(int listPlace = 0; listPlace < booklist.size()-1; listPlace++) {
			// SWITCH
			if(booklist.get(listPlace).getTitle().charAt(0) > booklist.get(listPlace+1).getTitle().charAt(0) ) {
				Book temp = booklist.get(listPlace);
				booklist.set(listPlace, booklist.get(listPlace+1));
				booklist.set(listPlace+1, temp);
				
				// start over
				listPlace=-1;
			}
//			else if(booklist.get(listPlace).getTitle().charAt(chIndex) == booklist.get(listPlace+1).getTitle().charAt(chIndex) ) {
//				while( booklist.get(listPlace).getTitle().charAt(chIndex) == booklist.get(listPlace+1).getTitle().charAt(chIndex) ) {
//					chIndex++;
//				}
//				// SWITCH
//				if(booklist.get(listPlace).getTitle().charAt(chIndex) > booklist.get(listPlace+1).getTitle().charAt(chIndex) ) {
//					Book temp = booklist.get(listPlace);
//					booklist.set(listPlace, booklist.get(listPlace+1));
//					booklist.set(listPlace+1, temp);
//					
//					// start over
//					chIndex = 0;
//					listPlace=-1;
//				}
//			}
		}
	}
	
	/**
	 *sort_price function sort BookList by book price attribute from least to greatest
	 */
	public static void sort_price() {
		for(int i = 0; i < booklist.size()-1; i++) {
			if(booklist.get(i).getPrice() > booklist.get(i+1).getPrice() ) {
				Book temp = booklist.get(i);
				booklist.set(i, booklist.get(i+1));
				booklist.set(i+1, temp);
				i=0;
			}
			
		
		}
	}
	
	/**
	 *sort_quantity function sort BookList by book quantity attribute from least to greatest
	 */
	public static void sort_quantity() {
		for(int i = 0; i < booklist.size()-1; i++) {
			if(booklist.get(i).getQuantity() > booklist.get(i+1).getQuantity() ) {
				Book temp = booklist.get(i);
				booklist.set(i, booklist.get(i+1));
				booklist.set(i+1, temp);
				i=0;
			}
		
		}
	}
	
	/**
	 * return_list_to_string function stores BookList in one string 
	 * @return String str stores BookList as a string
	 */
	public static String return_list_to_string() {
		String str = "";
		
		// List
		for(int i = 0; i < booklist.size(); i++) {
			
			// Item
			str += booklist.get(i).getSku()   + " ";
			str += booklist.get(i).getTitle() + " ";
			str += booklist.get(i).getPrice() + " ";
			str += booklist.get(i).getQuantity() +"\n";
		
		}
		return str;
	}
	
	/**
	 * increment_quantity function finds book by sku and increments quantity if exists
	 * @param sku int stores sku user input
	 */
	public static void increment_quantity(int sku) {
		Book temp = BookList.get_book_by_sku(sku);
		temp.setQuantity(temp.getQuantity()+1);	
	}
}
