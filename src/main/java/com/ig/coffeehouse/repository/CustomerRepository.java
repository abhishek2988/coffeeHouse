/**
 * 
 */
package com.ig.coffeehouse.repository;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ig.coffeehouse.common.CoffeeHouseInMemoryDbManager;
import com.ig.coffeehouse.dto.Customer;

/**
 * @author abhisagrawal
 *
 */
@Repository
public class CustomerRepository {

	/**Repository method to add customer to 
	 * in memory data structure
	 * @param customer
	 */
	public void addCustomer(Customer customer) {
		
		CoffeeHouseInMemoryDbManager.customerMap.put(customer, customer);
		
	}

	public Map<Customer, Customer> getRegisteredCustomers() {
		
		return CoffeeHouseInMemoryDbManager.customerMap;
		
	} 
	
	
}
