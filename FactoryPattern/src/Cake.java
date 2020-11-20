import java.util.ArrayList;

public abstract class Cake {

	protected ArrayList<String> ingredients;
	protected String name;
	protected String baseFlavor;

	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @return the baseFlavor
	 */
	public String getBaseFlavor() {
		return baseFlavor;
	}


	public String getIngredients() {
		String str = "";
		for(int i = 0; i < ingredients.size(); i++) {
			str += "/n" + ingredients.get(i);
		}
		return str;
	}

	/**
	 * prepare function prepares the cake
	 */
	public void prepare() {
		System.out.println("Preparing " + this.toString());
	}
	
	/**
	 * bake function bakes the cake
	 */
	public void bake() {
		System.out.println("Baking " + this.toString());
	}
	
	/**
	 * box function boxes the cake
	 */
	public void box() {
		System.out.println("Boxing " + this.toString());
	}
	
	/**
	 * Override toString function returning name and flavor
	 */
	public String toString() {
		return name + " with a base flavor of " + baseFlavor;
	}
	
}
