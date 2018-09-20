package com.ig.coffeehouse.dto;

public class DailyReport {
	private String coffeeVariety;
	private int totalServings;
	private int totalServingsSold;
	/**
	 * @return the coffeeVariety
	 */
	public String getCoffeeVariety() {
		return coffeeVariety;
	}
	/**
	 * @param coffeeVariety the coffeeVariety to set
	 */
	public void setCoffeeVariety(String coffeeVariety) {
		this.coffeeVariety = coffeeVariety;
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
	/**
	 * @return the totalServingsSold
	 */
	public int getTotalServingsSold() {
		return totalServingsSold;
	}
	/**
	 * @param totalServingsSold the totalServingsSold to set
	 */
	public void setTotalServingsSold(int totalServingsSold) {
		this.totalServingsSold = totalServingsSold;
	}
	@Override
	public String toString() {
		return "DailyReport [coffeeVariety=" + coffeeVariety + ", totalServings=" + totalServings
				+ ", totalServingsSold=" + totalServingsSold + "]";
	}
	
}
