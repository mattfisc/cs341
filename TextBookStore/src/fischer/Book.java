package fischer;

public class Book {
	
	private int sku;
	private String title;
	private double price;
	private int quantity;

	
	
	public Book(int sku,String title,double price) {
		this.sku = sku;
		this.title = title;
		this.price = price;
		this.quantity = 1;
	}
	
	/**
	 * toString override function to display all book attributes
	 */
	public String toString() {
		return this.getSku() + " " + this.getTitle() + " " + this.getPrice() + " " + this.getQuantity();
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
	 * @return the sku
	 */
	public int getSku() {
		return sku;
	}

	/**
	 * @param sku the sku to set
	 */
	public void setSku(int sku) {
		this.sku = sku;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
