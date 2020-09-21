package fischer;

import java.util.Vector;

public class App {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.insertNode(8);
		tree.insertNode(2);
		tree.insertNode(7);
		tree.insertNode(9);
		tree.insertNode(11);
		
		
	
		
		//tree.printTree(tree.getHead());
		
		tree.deleteNode(2);
		
		tree.printTree(tree.getHead());
		
	}
}
