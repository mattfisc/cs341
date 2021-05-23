
public class MyMain {

	/**
	 * main function launches application
	 * @param args
	 */
	public static void main(String[] args) {
		
		CakeFactory cakeFactory = new CakeFactory();
		CakeStore store = new CakeStore(cakeFactory);
		
		Cake cake1 = store.onlineOrder("chocolate");
		System.out.println("Completed Order: " + cake1.getName() + "\n");
		System.out.println(cake1.getIngredients());
		
		Cake cake2 = store.onlineOrder("lemon");
		System.out.println("Completed Order: " + cake2.getName() + "\n");
		System.out.println(cake2.getIngredients());

		Cake cake3 = store.onlineOrder("vanilla");
		System.out.println("Completed Order: " + cake3.getName() + "\n");
		System.out.println(cake3.getIngredients());
		
	}
	
}
