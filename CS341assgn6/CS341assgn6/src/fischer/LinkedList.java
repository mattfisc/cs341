package fischer;

/**
 * 
 * @author Matthew Fischer
 *
 */
public class LinkedList {

	private Node head;
	private Node tail;

	

	/**
	 * @param head Node is the pointer to the head of the list
	 * @param tail Node is the pointer to the tail of the list
	 * 
	 */
	public LinkedList() {
		this.head = null;
		this.tail = null;


	}
	
	/**
	 * addNode function will add a real number to the end of the LinkedList
	 * 
	 * @param n double stores a double
	 */
	public void addNode(String str) {
		if(this.head == null && this.tail == null) {
			this.head = new Node(str);
			this.tail = this.head;

		}
		else if(this.head == this.tail) {
			this.tail = new Node(str);
			this.head.setNext(this.tail);
			tail.setPrev(this.head);
		}
		else{
			Node temp = new Node(str);
			tail.setNext(temp);
			temp.setPrev(tail);
			tail = temp;
			
		}
	}
	
	
	



	/**
	 * print_list function that prints the list in order from head to tail.
	 */
	public void print_list() {
		if(this.head != null) {
			Node tracker = this.head;
			
			while(tracker != tail) {
				System.out.println(tracker.getName() + " Count: " + tracker.getCount() + "\n");
				tracker = tracker.getNext();
			}
			// TAIL CALCULATION
			System.out.println(tracker.getName() + " Count: " + tracker.getCount() + "\n");
		}
		else {
			System.out.println("Empty list");
		}
		
	}
	public String toString() {
		if(this.head == null) {
			return "";
		}
		
		Node tracker = this.head;
		String str= "";
		while(tracker != tail) {
			str += tracker.getName()  + " Count: " + tracker.getCount() +"\n";
			tracker = tracker.getNext();
		}
		// TAIL CALCULATION
		str += tracker.getName() + " Count: " + tracker.getCount() +"\n";
		return str;
	}
	

	
	/**
	 * size function returns the size of the linkedList
	 * @param tracker Node tracks through LinkedList
	 * @param count int is the size of the LinkedList
	 * @return count stored size of LinkedList
	 */
	public int size() {
		Node tracker = this.head;
		int count = 0;
		while(tracker != tail) {
			count++;
			tracker = tracker.getNext();
		}
		count++;
		
		return count;
	}
	
	/**
	 * findNode function finds a token in the list created read in by the class
	 * 
	 * @param tracker Node 
	 * @param text
	 * @return
	 */
	public Node findNode(String text) {
		Node tracker = this.head;
		if(tracker == null)
			return null;
		
		while(tracker != tail) {
			if(tracker.getName().equals(text)) {
				return tracker;
			}
			tracker = tracker.getNext();
			
		}
		return null;
	}
	
	
}
