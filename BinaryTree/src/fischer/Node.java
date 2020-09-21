package fischer;

/**
 * 
 * @author Matthew Fischer
 *
 */
public class Node {

	private int n;
	private Node left;
	private Node right;
	private boolean visited;
	
	/**
	 * Node Constructor
	 * 
	 * @param n int value of the Node
	 */
	public Node(int n) {
		this.n = n;
		this.left = null;
		this.right = null;
		this.visited = false;

	}

	/**
	 * @return the n
	 */
	public int getN() {
		return n;
	}

	/**
	 * @param n the n to set
	 */
	public void setN(int n) {
		this.n = n;
	}

	/**
	 * @return the left
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(Node left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(Node right) {
		this.right = right;
	}

	/**
	 * @return the visited
	 */
	public boolean getVisited() {
		return visited;
	}

	/**
	 * @param visited the visited to set
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	
	
	
}
