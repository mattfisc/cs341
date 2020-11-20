
public class CakeStore {

	private CakeFactory cakeFactory;
	
	/**
	 * Constuctor
	 * @param cakeFactory object to set CakeFactory attribute
	 */
	public CakeStore(CakeFactory cakeFactory) {
		this.cakeFactory = cakeFactory;
	}
	
	/**
	 * onlineOrder function sends a string to CakeFactory and returns a cake object
	 * @param type String input order for cake
	 * @return cake object once cake is constructed
	 */
	public Cake onlineOrder(String type) {
		// COMPLETE THE ONLINE ORDER
		Cake cake = cakeFactory.orderCake(type);
		
		// PREPARATION OF CAKE
		cake.prepare();
		cake.bake();
		cake.box();
		
		return cake;
	}
}
