package fischer;



public class assertions {

	public static void main(String[] args) {
		System.out.println(Math.random());
		
		
		
		
		for(int i = 0; i < 1000; i++) {
			double r = Math.random() * 10000;
			double sqValue = square_root_check(r);
			System.out.println("sqrt r: "+ r + " = " + sqValue);
			
			
		}
		System.out.println("successful");
	}
	
	public static double square_root_check(double num) {
		assert(num >= 0):"pre-condition not successful";
		
		double epsilon = 10e-7;
		double root = Math.sqrt(num);
		
		assert Math.abs( root * root - num) < epsilon: "Post-condition: root ^ 2 == num";
		return root;
	}
		
}
