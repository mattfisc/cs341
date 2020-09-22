package fischer;

/**
 * 
 * @author Matthew Fischer
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
	public Node insert(Node head, int n){ 
	    // CREATE NEW NODE
	    Node temp = new Node(n); 
	   
	    // PLACEMENT LOCATION TRACKER
	    Node tracker = head; 
	   
	    // PARENT POINTER 
	    Node parent = null; 
	   
	    while (tracker != null) { 
	    	parent = tracker; 
	        if (n <= tracker.getN()) 
	        	tracker = tracker.getLeft(); 
	        else
	        	tracker = tracker.getRight(); 
	    } 
	   
	    //TREE IS EMPTY
	    if (parent == null) 
	    	parent = temp; 
	   
	    // LEFT CHILD 
	    else if (n <= parent.getN()) 
	    	parent.setLeft(temp); 
	   
	    // RIGHT CHILD
	    else
	    	parent.setRight(temp);; 
	   
	    // RETURN NODE PARENT
	    return parent;
	} 
	
	
	
	/**
	 * deleteNode function will delete a int in the binarytree
	 * 
	 * @param parent is the tracing head node through the tree
	 * @param n is the value to find and delete
	 * @param child Node to be deleted Node with value n
	 */
	public static void deleteNode(Node parent,int n) {
		
		Node child = null;
		
		if(parent.getLeft().getN() == n)
			child = parent.getLeft();
		if(parent.getRight().getN() == n)
			child = parent.getRight();
		
		// CHILD IS NODE TO DELETE
		if(child != null) {

			// NO CHILDREN
			if(child.getLeft() == null && child.getRight() == null) {
				child = null;
			}
			// BOTH CHILDREN
			else if(child.getLeft() != null && child.getRight() != null) {
				Node temp = child.getRight();
				
				if(parent.getLeft() == child)
					parent.setLeft(child.getLeft());
				else
					parent.setRight(child.getLeft());
				
				child = child.getLeft();
				while(child.getRight() != null)
					child = child.getRight();
				
				child.setRight(temp);
			}
			// LEFT CHILDREN
			else if(child.getRight() == null) {
				if(parent.getLeft() == child)
					parent.setLeft(child.getLeft());
				else
					parent.setRight(child.getLeft());
			}

			// RIGHT CHILDREN
			else if(child.getLeft() == null) {
				if(parent.getLeft() == child)
					parent.setLeft(child.getRight());
				else
					parent.setRight(child.getRight());
			}
				
		
		}
		// SEARCH LEFT
		else if(n < parent.getN()) {
			deleteNode(parent.getLeft(),n);
		}
		// SEARCH RIGHT
		else if(n > parent.getN()) {
			deleteNode(parent.getRight(),n);
		}
		
	}
	
	
	/**
	 * 
	 * @param n is the value searching for in tree
	 * @return found n is boolean
	 */
	public boolean searchTree(Node tracer,int n) {
		if( n == tracer.getN() )
			return true;
		if( n < tracer.getN() )
			searchTree(tracer.getLeft(), n);
		else
			searchTree(tracer.getRight(),n);
		return false;
	}
	
	/**
	 * printTree display the tree Print Left,Node value, Right
	 * @param tracer Node is the temp Node that traces through the binary tree
	 */
	public void printInOrder(Node tracer) {
		// TRANSVERSE TREE
		
		if(tracer.getLeft() != null)
			printInOrder(tracer.getLeft());
		
		System.out.print(tracer.getN() + " ");
		
		if(tracer.getRight() != null)
			printInOrder(tracer.getRight());
		
	}	
	public void printPreFix(Node tracer) {
		// TRANSVERSE TREE
		System.out.print(tracer.getN() + " ");
		
		if(tracer.getLeft() != null)
			printPreFix(tracer.getLeft());
		
		if(tracer.getRight() != null)
			printPreFix(tracer.getRight());
		
	}
	public void printPostFix(Node tracer) {
		// TRANSVERSE TREE
		
		if(tracer.getLeft() != null)
			printPostFix(tracer.getLeft());
		
		if(tracer.getRight() != null)
			printPostFix(tracer.getRight());
		
		System.out.print(tracer.getN() + " ");
		
	}
	

	
	public int size() {
		return this.length;
	}
	
}
