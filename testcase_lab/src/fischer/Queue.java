package fischer;

import java.util.NoSuchElementException;

/**
 * 
 * @author Matthew Fischer
 *
 */
public class Queue {

	private Node head;
	private Node tail;
	
	/**
	 * Queque constructor
	 * 
	 */
	public Queue() {
		head = null;
		tail = null;
	}
	
	
	/**
	 * isEmpty returns if the list is empty
	 * 
	 * @return boolean is the head Node null
	 */
	public boolean isEmpty() {
		return head == null;
	}
	
	/**
	 * enqueue method adds a node to the end of the list with the n value
	 * @param value int value of new Node
	 * @param temp Node add temp to end of the queue list
	 */
	public void enqueue(int value) {
		Node temp = new Node(value);
		
		tail = temp;
		// EMPTY QUE
		if(head == null) 
			head = temp;
		// NOT EMPTY QUE
		else
			tail.setNext(temp);
	}
	
	/**
	 * dequeue method returns the value of head Node and 
	 * changes the Head of the list to next Node
	 * 
	 * @return head.n 
	 */
	public int dequeue() {
		//EMPTY QUE
		if(isEmpty()) {
			throw new NoSuchElementException("Runtime Exception");
		}
		// ONE NODE IN QUE
		else if(head == tail) {
			int frontItem = head.getN();
			head = null;
			tail = null;
			return frontItem;
		}
		// MANY NODES IN QUE
		else {
			int frontItem = head.getN();
			head = head.getNext();
			return frontItem;
		}
	}
	
	/**
	 * 
	 * @return head Node
	 */
	public Node getHead() {
			return head;
	}
	
	
}
