package fischer;
import java.util.LinkedList;

public class BookList {

	
	public static LinkedList<Book> booklist = new LinkedList<Book>();
	
	
	public static Book get_book_by_sku(int num) {
		for(int i = 0; i < booklist.size(); i++) {
			if(booklist.get(i).getSku() == num) {
				return booklist.get(i);
			}
		
		}
		return null;
	}
	
	public static Book remove_book_by_sku(int num) {
		for(int i = 0; i < booklist.size(); i++) {
			if(booklist.get(i).getSku() == num) {
				return booklist.remove(i);
			}
		
		}
		return null;
	}
	
	public static void sort_sku() {
		for(int i = 0; i < booklist.size()-1; i++) {
			if(booklist.get(i).getSku() > booklist.get(i+1).getSku()) {
				Book temp = booklist.get(i);
				booklist.set(i, booklist.get(i+1));
				booklist.set(i+1, temp);
				i=0;
			}
		
		}
	
	}
	
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
	
	public static String returnListToString() {
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
	
	public static void incrementQuantity(int sku) {
		Book temp = BookList.get_book_by_sku(sku);
		temp.setQuantity(temp.getQuantity()+1);
		
	}
}
