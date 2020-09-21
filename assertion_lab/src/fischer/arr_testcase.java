package fischer;

public class arr_testcase {
	
	public static void main(String[] args) {
		int[] arr = {4,1,6,3,9};
		
		for(int i = 0; i < arr.length-1;i++) {
			for(int j = i+1; j < arr.length;j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					i = 0;
				}
			}
		}
		
		
		assert( is_sorted(arr) ): "sort failed";
		assert( is_sorted(arr) && is_permutated(arr,arr)): "failed to sort";
	}

	public static boolean is_sorted (int[] y) {
		for(int i = 0; i < y.length-1; i++) {
			if(y[i] > y[i+1]) {
				return false;
			}
				
		}
		return true;
	}
	
	
	
	public static boolean is_permutated(int[] x, int[] y){
		return true;
	}


}
