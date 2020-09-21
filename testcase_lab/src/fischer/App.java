package fischer;

/**
 * 
 * @author Matthew Fischer
 * 
 */
public class App {

	/**
	 * Runs application
	 * 
	 * @param args 
	 */
	public static void main(String[] args) {

		Queue list = new Queue();
		System.out.println(list.isEmpty());
		
		
		//System.out.println(list.dequeue());
		
		
		list.enqueue(1);
		System.out.println(list.getHead());
		
		System.out.println(list.dequeue());
		
		System.out.println(list.getHead());
	}

}
