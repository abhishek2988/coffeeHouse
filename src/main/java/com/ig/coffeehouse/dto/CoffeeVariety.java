/**
 * 
 */
package com.ig.coffeehouse.dto;

/**
 * @author abhisagrawal
 *
 */
public class CoffeeVariety {
	
	private String coffeeName;
	private String coffeeDescricption;
	private int totalServings;
	private int availableServings;
	
	/**
	 * @return the availableServings
	 */
	public int getAvailableServings() {
		return availableServings;
	}
	/**
	 * @param availableServings the availableServings to set
	 */
	public void setAvailableServings(int availableServings) {
		this.availableServings = availableServings;
	}
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
	 * @return the coffeeDescricption
	 */
	public String getCoffeeDescricption() {
		return coffeeDescricption;
	}
	/**
	 * @param coffeeDescricption the coffeeDescricption to set
	 */
	public void setCoffeeDescricption(String coffeeDescricption) {
		this.coffeeDescricption = coffeeDescricption;
	}
	/**
	 * @return the totalServings
	 */
	public int getTotalServings() {
		return totalServings;
	}
	/**
	 * @param totalServings the totalServings to set
	 */
	public void setTotalServings(int totalServings) {
		this.totalServings = totalServings;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coffeeName == null) ? 0 : coffeeName.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CoffeeVariety other = (CoffeeVariety) obj;
		if (coffeeName == null) {
			if (other.coffeeName != null)
				return false;
		} else if (!coffeeName.equals(other.coffeeName))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "CoffeeVariety [coffeeName=" + coffeeName + ", coffeeDescricption=" + coffeeDescricption
				+ ", totalServings=" + totalServings + ", availableServings=" + availableServings + "]";
	}
	
	

}
