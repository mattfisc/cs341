package fischer;

/**
 * 
 * @author Matthew Fischer
 *
 */
public class BinaryTree {

	private Node head;
	private int length;
	/**
	 * 
	 * Constructor
	 * 
	 * @param head Node is the head node in the tree
	 */
	public BinaryTree() {
		this.head = null;
		this.length = 0;
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
	 * @return the length
	 */
	public int getLength() {
		return length;
	}


	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}


	/**
	 * 
	 * @return if tree is empty
	 */
	public boolean isEmpty() {
		return this.head == null;
	}
	
	/**
	 * insertNode inserts a node at bottom of the binary tree 
	 * 
	 * @param n int value of new Node
	 * @param tracker Node tracks through the tree
	 */
	public void insertNode(int n) {
		// INCREASE LENGTH
		this.length++;
		
		// LIST IS EMPTY
		if(this.head == null) 
			head = new Node(n);
		// LIST IS NOT EMPTY
		else {
			Node tracker = head;
			
			// FIND THE PLACEMENT
			while(tracker != null) {
				
				// n is less than tracker
				// go left
				if(n <= tracker.getN()) {
					// left null add Node
					if(tracker.getLeft() == null) 
						tracker.setLeft(new Node(n));
						
					// tracker goes left
					else
						tracker = tracker.getLeft();
				}
				// if n is greater than tracker
				// go right
				else if(n > tracker.getN()) {
					// right is null
					if(tracker.getRight() == null)
						tracker.setRight(new Node(n));
					// tracker goes right
					else
						tracker = tracker.getRight();
				}
			}
			// tracker is null
			// add new node
			tracker = new Node(n);
		}
	}
	
	/**
	 * deleteNode will delete a Node off the binary tree
	 * 
	 * @param n int is the number to delete in the binary tree
	 * @param tracker Node traces through the binary tree
	 */
	public void deleteNode(int n) {
		// EMPTY LIST
		if(this.head == null) 
			head = new Node(n);
		// NOT EMPTY LIST
		else {
			Node tracker = head;
			while(tracker != null) {

				// NODE FOUND
				if( n == tracker.getN() )
					// NO CHILDREN
					if(tracker.getLeft() == null && tracker.getRight() == null)
						tracker = null;
					// BOTH CHILDREN EXIST
					else if(tracker.getLeft() != null && tracker.getRight() != null) {
						// GET RIGHT CHILD
						Node rightChild = tracker.getRight();
						// GET LEFT CHILD
						Node leftChild = tracker.getLeft();
						// REMOVE NODE
						// ADD RIGHT SIDE
						tracker = rightChild;
						// ADD LEFT UNDER RIGHT CHILD NEXT SPOT
						while(tracker.getLeft() != null) {
							tracker = tracker.getLeft();
						}
						// ADD LEFT CHILD ONTO RIGHT TREE
						tracker = leftChild;
					}
					// ONLY LEFT CHILD EXISTS
					else if(tracker.getLeft() != null) {
						Node temp = tracker.getLeft();
						// DELETE AND SAVE LEFT SIDE OF TREE
						tracker = temp;
					}
					// ONLY RIGHT CHILD EXISTS
					else if(tracker.getRight() != null) {
						Node temp = tracker.getRight();
						// DELETE AND SAVE RIGHT SIDE OF TREE
						tracker = temp;
					}
				// SEARCH LEFT
				else if(n < tracker.getN()) {
					tracker = tracker.getLeft();
				}
				// SEARCH RIGHT 
				else if(n > tracker.getN()) {
					tracker = tracker.getRight();
				}
				
			}
		}
		
	}
	
	
	/**
	 * 
	 * @param n is the value searching for in tree
	 * @return found n is boolean
	 */
	public boolean searchTree(int n) {
		// empty list
		if(this.head == null) 
			head = new Node(n);
		// not empty list
		else {
			Node tracker = head;
			while(tracker != null) {
				// n found
				if( n == tracker.getN() )
					return true;
				// if left
				else if(n < tracker.getN()) {
					tracker = tracker.getLeft();
				}
				// if right 
				else if(n > tracker.getN()) {
					tracker = tracker.getRight();
				}
				
			}
		}
		return false;
	}
	
	/**
	 * printTree display the tree Print Center,Left,Right
	 * @param Head
	 */
	public void printTree(Node head) {
		// TRANSVERSE TREE
		System.out.println(head.getN() + " ");
		if(head.getLeft() != null)
			printTree(head.getLeft());
		if(head.getRight() != null)
			printTree(head.getRight());
		
	}	
	
	// prefix top,left,right
	// postfix 
	// 
	
	
	public int size() {
		return this.length;
	}
	
}

