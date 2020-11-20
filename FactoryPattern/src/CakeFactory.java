
public class CakeFactory {

	/**
	 * orderCake function takes a string and returns a cake object
	 * @param type String input to tell what cake object to create
	 * @return Cake object
	 */
	public Cake orderCake(String type) {
		if(type.equals("vanilla"))
			return new VanillaCake();
		else if(type.equals("chocolate"))
			return new ChocolateCake();
		else
			return new LemonCake();
	}
	
}
