package fischer;

public class MyMain {

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		tree.setHead(tree.insert(tree.getHead(),8));
	
		assert( nodeNoChildren( tree.getHead()) ): "Node has children";
		
		tree.insert(tree.getHead(),2);
		tree.insert(tree.getHead(),7);
		tree.insert(tree.getHead(),9);
		tree.insert(tree.getHead(),11);
		tree.insert(tree.getHead(),2);
		
	
		assert( nodeNoChildren( tree.getHead())  == false): "Node has no children";
		
		
		tree.printPreFix(tree.getHead());
		System.out.println("");
		assert( testInsertNode(tree,4) ): "Node insert not working";
		
		
		assert( cycleCheck(tree.getHead()) ):"Not a tree! Is a cycle";
		
		
		// LEFT CHILD SHOULD BE LEFT
		// RIGHT CHILD SHOULD BE GREATER 
		childParentCheck(tree.getHead());
		
		//System.out.println( tree.searchTree(tree.getHead(), 7).getN() );
		//tree.printTree(tree.getHead());
		
		assert( tree.searchTree(tree.getHead(),8) ):"not in tree";

		BinaryTree.deleteNode(tree.getHead(),7);
		
		tree.printPreFix(tree.getHead());
		System.out.println("");
		
		
		
		
		
		System.out.println("Success");
	}
	

	




/**
 * nodeNoChildren check if node has no children
 * @param temp_head
 * @return
 */
public static boolean nodeNoChildren(Node temp_head) {
	return temp_head.getLeft() == null && temp_head.getRight() == null;
}


/**
 * testInsertNode tests if node is inserted into tree
 * 
 * @param tree BinaryTree to insert value 
 * @param n int is the value to insert
 * @return true if inserted
 */
public static boolean testInsertNode(BinaryTree tree,int n){
	if(tree.getHead() == null) {
		tree.insert(tree.getHead(),n);
		assert( new Node(n) == tree.getHead() && nodeNoChildren(tree.getHead()) ):"Add to empty tree is not working";
	}
	else {
		tree.insert(tree.getHead(),n);
		assert(tree.searchTree(tree.getHead(),n) == false):"Insert failed";
		// POST ASSERT
		
	}
	return true;
}


/**
 * cycleCheck is a recursive check.  For a visited attribute to check if any node has more than one parent.
 * 
 * @param head Node is a node to track through a binary tree
 * @return boolean value if node has more than one parent
 */
public static boolean cycleCheck(Node head) {
	// TRANSVERSE TREE
	if(head.getVisited() == false)
		head.setVisited(true);
	else
		return false;
	
	if(head.getLeft() != null)
		cycleCheck(head.getLeft());
	if(head.getRight() != null)
		cycleCheck(head.getRight());
	
	return true;
}

/**
 * childParentCheck recursive check for a node. Left child should be less than parent node and
 * checks right child is greater than parent node
 * 
 * @param head Node is a tracker node to check children values
 */
public static void childParentCheck(Node head) {
	assert(head.getLeft().getN() < head.getN()):"left side greater than parent";
	assert(head.getRight().getN() > head.getN()):"right side less than parent";
	
	if(head.getLeft() != null)
		cycleCheck(head.getLeft());
	if(head.getRight() != null)
		cycleCheck(head.getRight());
	
}



}
