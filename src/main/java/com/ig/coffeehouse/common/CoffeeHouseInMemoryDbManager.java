/**
 * 
 */
package com.ig.coffeehouse.common;

import java.util.HashMap;
import java.util.Map;

import com.ig.coffeehouse.dto.CoffeeVariety;
import com.ig.coffeehouse.dto.Customer;

/**
 * @author abhisagrawal
 *
 */
public class CoffeeHouseInMemoryDbManager {
	
	public static Map<String, CoffeeVariety> coffeeMap = new HashMap<>();
	public static Map<Customer, Customer> customerMap = new HashMap<>();
	/**
	 * @return the coffeeMap
	 */
	public static Map<String, CoffeeVariety> getCoffeeMap() {
		return coffeeMap;
	}
	/**
	 * @param coffeeMap the coffeeMap to set
	 */
	public static void setCoffeeMap(Map<String, CoffeeVariety> coffeeMap) {
		CoffeeHouseInMemoryDbManager.coffeeMap = coffeeMap;
	}
	/**
	 * @return the customerMap
	 */
	public static Map<Customer, Customer> getCustomerMap() {
		return customerMap;
	}
	/**
	 * @param customerMap the customerMap to set
	 */
	public static void setCustomerMap(Map<Customer, Customer> customerMap) {
		CoffeeHouseInMemoryDbManager.customerMap = customerMap;
	}
}
