package fischer;

/**
 * 
 * @author Matthew Fischer
 *
 */
public class Node {

	private String name;
	private int count;
	private int lineCount;
	private Node next;
	private Node prev;
	
	/**
	 * Constructor Node function
	 * @param name String
	 */
	public Node(String name) {
		this.name = name;
		this.count = 1;
		this.lineCount = 0;
		this.next = null;
		this.prev = null;
	}

	

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}



	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the lineCount
	 */
	public int getLineCount() {
		return lineCount;
	}



	/**
	 * @param lineCount the lineCount to set
	 */
	public void setLineCount(int lineCount) {
		this.lineCount = lineCount;
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

	/**
	 * @return the prev
	 */
	public Node getPrev() {
		return prev;
	}

	/**
	 * @param prev the prev to set
	 */
	public void setPrev(Node prev) {
		this.prev = prev;
	}
	
	
	
	
}
