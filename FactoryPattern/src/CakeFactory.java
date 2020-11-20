
public class CakeFactory {

	/**
	 * orderCake function takes a string and returns a cake object
	 * @param type String input to tell what cake object to create
	 * @return Cake object
	 */
	public Cake orderCake(String type) {
		Cake cake = null;
		if(type.equals("vanilla")) 
			cake = new VanillaCake();
		else if(type.equals("chocolate"))
			cake = new ChocolateCake();
		else 
			cake = new LemonCake();
		
		cake.addIngredient(cake.baseFlavor);
		cake.addBasicIngredients();
		
		return cake;
	}
	
}
