/**
 * 
 */
package com.ig.coffeehouse.dto;

/**
 * @author abhisagrawal
 *
 */
public class CoffeeOrder {
	
	private String coffeeName;
	private int quantity;
	/**
	 * @return the coffeeName
	 */
	public String getCoffeeName() {
		return coffeeName;
	}
	/**
	 * @param coffeeName the coffeeName to set
	 */
	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
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
	@Override
	public String toString() {
		return "CoffeeOrder [coffeeName=" + coffeeName + ", quantity=" + quantity + "]";
	}
	
	
	

}
