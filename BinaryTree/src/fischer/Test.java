package fischer;

import java.util.Vector;

public class Test {

	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.insertNode(8);

		assert( node_no_children( tree.getHead()) ): "Node has children";
		
		
		tree.insertNode(2);
		tree.insertNode(7);
		tree.insertNode(9);
		tree.insertNode(11);
		
		assert( node_no_children( tree.getHead())  == false): "Node has no children";
		
		

		//assert( test_insertNode(tree,4) ): "Node insert not working";
		
		
		
		Node x = tree.getHead();
		boolean y = tree.getHead().getVisited();
		assert( cycleCheck(x, true) ):"Not a tree! Is a cycle";
	}
	
	
	// not working
	public static boolean node_no_children(Node temp_head) {
		return temp_head.getLeft() == null && temp_head.getRight() == null;
	}
	
	
	public static boolean test_insertNode(BinaryTree tree,int n){
		if(tree.getHead() == null) {
			tree.insertNode(n);
			assert( new Node(n) == tree.getHead() && node_no_children(tree.getHead()) ):"Add to empty tree is not working";
		}
		else {
			// pre not in list
			
			tree.insertNode(n);
			// post added to list
			
			
		}
		return true;
	}
	
	
	
	public static boolean cycleCheck(Node head,boolean check) {
		// TRANSVERSE TREE
		if(head.getVisited() == check)
			head.setVisited(!check);
		else
			return false;
		if(head.getLeft() != null)
			cycleCheck(head.getLeft(),check);
		if(head.getRight() != null)
			cycleCheck(head.getRight(),check);
		return true;
	}	
	
	
	
}
