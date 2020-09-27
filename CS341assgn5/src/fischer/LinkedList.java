package fischer;

public class LinkedList {

	private Node head;
	private Node tail;
	
	double n_mean;
	double sd_num;
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.n_mean = 0;
		this.sd_num = 0;
		

	}
	
	public void addNode(double n) {
		if(this.head == null && this.tail == null) {
			this.head = new Node(n);
			this.tail = this.head;

		}
		else if(this.head == this.tail) {
			this.tail = new Node(n);
			this.head.setNext(this.tail);
			tail.setPrev(this.head);
		}
		else{
			Node temp = new Node(n);
			tail.setNext(temp);
			temp.setPrev(tail);
			tail = temp;
			
		}
	}
	
	public void printList() {
		Node tracker = this.head;
		
		while(tracker.getNext() != null) {
			System.out.println(tracker.getN());
			tracker = tracker.getNext();
		}
	}
	
	public double get_mean() {
		n_mean = 0;
		int count = 0;
		Node tracker = this.head;
		
		while(tracker.getNext() != null) {
			count++;
			n_mean += tracker.getN();
			tracker = tracker.getNext();
		}
		n_mean /= count;
		System.out.println(n_mean);
		return n_mean;
	}
	
	public double get_standardDeviation() {
		if(this.n_mean == 0)
			get_mean();
		
		int count = 0;
		Node tracker = this.head;
		sd_num = 0;
		
		while(tracker.getNext() != null) {
			count++;
			sd_num += Math.pow((tracker.getN() - n_mean),2);
			tracker = tracker.getNext();
		}
		
		sd_num /= count;
		sd_num = Math.sqrt(sd_num);
		return sd_num;
	}
	
	public int size() {
		Node tracker = this.head;
		int count = 0;
		while(tracker.getNext() != null) {
			count++;
			tracker = tracker.getNext();
		}
		return count;
	}
}
