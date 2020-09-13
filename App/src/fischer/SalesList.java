package fischer;

import java.util.ArrayList;

public class SalesList {
	/**
	 * Sales List class
	 * @param list Arraylist of Item objects
	 * @param total double of all item costs.
	 */
	private ArrayList<Item> list;
	private double total;
	
	public SalesList(){
		list = new ArrayList<Item>();
		total = 0;
	}

	/**
	 * Get list method
	 * @return the list
	 */
	public ArrayList<Item> getList() {
		return list;
	}

	/**
	 * Set List method
	 * 
	 * @param list the list to set
	 */
	public void setList(ArrayList<Item> list) {
		this.list = list;
	}

	/**
	 * Add item to list method
	 * 
	 * @param item object add to list
	 */
	public void addItem(Item item) {
		list.add(item);
		total += item.getCost() * item.getQuantity();
	}
	
	/**
	 * Remove item from list method
	 * 
	 * @param item object delete from list
	 */
	public void removeItem(Item item) {
		list.remove(item);
		total -= item.getCost() * item.getQuantity();
	}
	
	/**
	 * @return the list as a String
	 */
	public String toString() {
		String str = "";
		for(int i = 0; i < list.size();i++) {
			str += list.get(i).toString() + " \n";
		}
		return str;
	}

	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}

	
	
	
}

	
