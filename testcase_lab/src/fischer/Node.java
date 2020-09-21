package fischer;


/**
 * 
 * @author Matthew Fischer
 * 
 */
public class Node {

	
	private int n;
	private Node next;
	/**
	 * Class Node is a LIFO(LAST IN FIRST OUT) object list
	 * @param n int stored value
	 * @param next Node for next in line
	 */
	public Node(int n) {
		this.n = n;
	}

	/**
	 * @return the n
	 */
	public int getN() {
		return this.n;
	}

	/**
	 * @param n the n to set
	 */
	public void setN(int n) {
		this.n = n;
	}

	/**
	 * @return the next
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Node next) {
		this.next = next;
	}
	
	
}
