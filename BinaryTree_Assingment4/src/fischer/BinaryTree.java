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
	 * insert method adds new node to the tree
	 * @param root Node is the base of the tree
	 * @param key int is the value to be added to the tree
	 * @return Node of the parent added
	 */
	public Node insert(Node root, int n){ 
	    // CREATE NEW NODE
	    Node addNode = new Node(n); 
	   
	    // PLACEMENT LOCATION TRACKER
	    Node tracker = root; 
	   
	    // PARENT POINTER 
	    Node parent = null; 
	   
	    while (tracker != null) { 
	    	parent = tracker; 
	        if (n < tracker.getN()) 
	        	tracker = tracker.getLeft(); 
	        else
	        	tracker = tracker.getRight(); 
	    } 
	   
	    //TREE IS EMPTY
	    if (parent == null) 
	    	parent = addNode; 
	   
	    // LEFT CHILD 
	    else if (n < parent.getN()) 
	    	parent.setLeft(addNode); 
	   
	    // RIGHT CHILD
	    else
	    	parent.setRight(addNode);; 
	   
	    // RETURN NODE PARENT
	    return parent; 
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
	public Node searchTree(Node tracer,int n) {
		if( n == tracer.getN() )
			return tracer;
		if( n < tracer.getN() )
			searchTree(tracer.getLeft(), n);
		else
			searchTree(tracer.getRight(),n);
		return null;
	}
	
	/**
	 * printTree display the tree Print Center,Left,Right
	 * @param Head
	 */
	public void printTree(Node head) {
		// TRANSVERSE TREE
		System.out.print(head.getN() + " ");
		if(head.getLeft() != null)
			printTree(head.getLeft());
		if(head.getRight() != null)
			printTree(head.getRight());
		
	}	
	

	
	public int size() {
		return this.length;
	}
	
}
