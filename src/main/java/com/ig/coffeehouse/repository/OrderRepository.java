/**
 * 
 */
package com.ig.coffeehouse.repository;

import org.springframework.stereotype.Repository;

import com.ig.coffeehouse.common.CoffeeHouseInMemoryDbManager;
import com.ig.coffeehouse.dto.CoffeeOrder;
import com.ig.coffeehouse.dto.CoffeeVariety;
import com.ig.coffeehouse.dto.Customer;
import com.ig.coffeehouse.dto.Order;

/**
 * @author abhisagrawal
 *
 */
@Repository
public class OrderRepository {
	

	/**Method to search registered customer
	 * @param order
	 * @return
	 */
	public Customer getCustomer(Order order) {
		
		return CoffeeHouseInMemoryDbManager.customerMap.get(order.getCustomer());
	}

	/**Method to return available coffee details
	 * @param cv
	 * @return
	 */
	public CoffeeVariety getCoffeeVariety(CoffeeOrder cv) {
		return CoffeeHouseInMemoryDbManager.coffeeMap.get(cv.getCoffeeName());
	}

	/**Update coffee details
	 * @param coffeeVariety
	 */
	public void updateCoffeeVarietyDetails(CoffeeVariety coffeeVariety) {
		CoffeeHouseInMemoryDbManager.coffeeMap.put(coffeeVariety.getCoffeeName(), coffeeVariety);
	}

}
