package com.ig.coffeehouse.dto;

import java.util.List;

/**
 * @author abhisagrawal
 *
 */
public class Order {

	private Customer customer;
	private List<CoffeeOrder> coffeeVarietyOrdered;
	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	/**
	 * @return the coffeeVarietyOrdered
	 */
	public List<CoffeeOrder> getCoffeeVarietyOrdered() {
		return coffeeVarietyOrdered;
	}
	/**
	 * @param coffeeVarietyOrdered the coffeeVarietyOrdered to set
	 */
	public void setCoffeeVarietyOrdered(List<CoffeeOrder> coffeeVarietyOrdered) {
		this.coffeeVarietyOrdered = coffeeVarietyOrdered;
	}
	
	@Override
	public String toString() {
		return "Order [customer=" + customer + ", coffeeVarietyOrdered=" + coffeeVarietyOrdered + "]";
	}
	
}
