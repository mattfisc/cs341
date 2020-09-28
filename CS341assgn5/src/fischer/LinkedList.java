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
	public void addNode(double n) {
		if(this.head == null && this.tail == null) {
			this.head = new Node(n);
			this.tail = this.head;

		}
		else if(this.head == this.tail) {
			this.tail = new Node(n);
			this.head.setNext(this.tail);
			tail.setPrev(this.head);
		}
		else{
			Node temp = new Node(n);
			tail.setNext(temp);
			temp.setPrev(tail);
			tail = temp;
			
		}
	}
	
	
	
	
	/**
	 * @return the head
	 */
	public Node getHead() {
		return head;
	}

	/**
	 * @param head the head to set
	 */
	public void setHead(Node head) {
		this.head = head;
	}

	/**
	 * @return the tail
	 */
	public Node getTail() {
		return tail;
	}

	/**
	 * @param tail the tail to set
	 */
	public void setTail(Node tail) {
		this.tail = tail;
	}

	/**
	 * print_list function that prints the list in order from head to tail.
	 */
	public void print_list() {
		Node tracker = this.head;
		
		while(tracker != tail) {
			System.out.println(tracker.getN());
			tracker = tracker.getNext();
		}
		// TAIL CALCULATION
		System.out.println(tracker.getN());
	}
	
	/**
	 * get_mean function adds all the values in the linked list and returns the mean
	 * 
	 * @param n_mean double stores total of all values on list / size
	 * @return n_mean is the mean of the LinkedList values to 4 decimal places
	 */
	public String get_mean() {
		double n_mean = 0;
		
		Node tracker = this.head;
		
		while(tracker != tail) {

			n_mean += tracker.getN();
			tracker = tracker.getNext();
		}
		// TAIL CALCULATION
		n_mean += tracker.getN();
		
		int count = size();

		n_mean /= count;
		
		return String.format( "%.4f", n_mean );
	}
	
	/**
	 * get_standard_deviation function returns the standard deviation from the LinkedList
	 * 
	 * @param n_mean double is the mean of the LinkedList
	 * @param tracker Node tracks through LinkedList
	 * @param sd_num double stores the standard deviation
	 * @param count int is the size of the LinkedList
	 * @return sd_num is the calculated standard deviation to the LinkedList to 4 decimal places
	 */
	public String get_standard_deviation(double n_mean) {
		
		

		Node tracker = this.head;
		double sd_num = 0;
		
		while(tracker != tail) {

			sd_num += Math.pow((tracker.getN() - n_mean),2);
			tracker = tracker.getNext();
		}
		// tail calculation
		sd_num += Math.pow((tracker.getN() - n_mean),2);
		
		int count = size();
		sd_num /= count;
		sd_num = Math.sqrt(sd_num);
		//return sd_num;
		return String.format( "%.4f", sd_num );
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
}
