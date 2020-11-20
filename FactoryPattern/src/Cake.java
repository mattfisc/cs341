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

	/**
	 * addIngredient function adds one ingredient to arraylist attribute
	 * @param ingredient String added to ingredients arraylist
	 */
	public void addIngredient(String ingredient) {
		ingredients.add(ingredient);
	}
	
	/**
	 * getIngredients function retrieves array string of ingredients
	 * @return String list of ingredients
	 */
	public String getIngredients() {
		String str = "";
		str += this.name + " ingredients: \n-----------\n";
		for(int i = 0; i < ingredients.size(); i++) {
			str +=  ingredients.get(i) + "\n" ;
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

	/**
	 * addBasicIngredients function add basic cake ingredients to ingredients list
	 */
	public void addBasicIngredients() {
		this.addIngredient("flour");
		this.addIngredient("water");
		this.addIngredient("sugar");
		this.addIngredient("salt");
	}
}
