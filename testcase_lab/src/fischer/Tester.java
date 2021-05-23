package fischer;

import java.util.NoSuchElementException;

public class Tester {
 
	public static void main(String[] args) {
		//A 
		Queue q = new Queue();
		if(!q.isEmpty()) {
			System.out.println("Test2 Failure");
			return;
		}
		
		// B
		try {
			int value = q.dequeue();
		}catch(NoSuchElementException e) {
			
		}catch(Exception e) {
			System.out.println("Test2 Failure");
			return;
		}
		if(q.getHead() != null) {
			System.out.println("test2 failure");
			return;
		}
		
		//C
		q.enqueue(1);
		if(q.getHead().getN() != 1){
			System.out.println("Test2 Failure");
			return;
		}
		
		//D
		int value = q.dequeue();
		Node test = q.getHead();
		assert(test,null):"failure";
		if(q.getHead() != null) {
			System.out.println("Test2 failure");
			return;
		}
		System.out.println("test 2 success");
		
	}
}
