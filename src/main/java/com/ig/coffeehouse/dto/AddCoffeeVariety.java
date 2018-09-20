/**
 * 
 */
package com.ig.coffeehouse.dto;

import java.util.List;

/**
 * @author abhisagrawal
 *
 */
public class AddCoffeeVariety {

	List<CoffeeVariety> coffeeVariety;

	/**
	 * @return the coffeeVariety
	 */
	public List<CoffeeVariety> getCoffeeVariety() {
		return coffeeVariety;
	}

	/**
	 * @param coffeeVariety the coffeeVariety to set
	 */
	public void setCoffeeVariety(List<CoffeeVariety> coffeeVariety) {
		this.coffeeVariety = coffeeVariety;
	}

	
	@Override
	public String toString() {
		return "AddCoffeeVariety [coffeeVariety=" + coffeeVariety + "]";
	}
}
