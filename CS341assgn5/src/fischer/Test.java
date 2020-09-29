package fischer;

public class Test {
	public Test() {
		
	}

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		
		list.addNode(6);
		list.addNode(6);
		list.addNode(6);
		
		list.addNode(5);
		assert(new Node(20.3) == list.getTail()):"node not added to tail";
		
		assert(list.size() == 4):"the size is not 10";
		
		double n_mean = Double.parseDouble(list.get_mean());
		
		assert(n_mean == 5.75):" mean is not 5.75";
		assert(Double.parseDouble( list.get_standard_deviation(n_mean) ) == .5): "standard deviation is not .5";
		
	}
}
