package fischer;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Item Class
 * 
 */
public class Item {

	private String name;
	private double cost;
	private int quantity;
	
	/**
	 * Item Constructor
	 * 
	 * @param name String add to Item attribute name
	 * @param cost double add to Item attribute cost
	 * @param quantity int add to Item attribute quantity
	 */
	public Item(String name, double cost, int quantity) {
	
		this.name = name;
		this.cost = cost;
		this.quantity = quantity;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * @return item as string
	 */
	public String toString() {
		NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US); 
		return this.name +"\t" + n.format(this.cost) + "\t" + this.quantity;
	}




}
