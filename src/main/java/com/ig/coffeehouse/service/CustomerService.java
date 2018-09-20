/**
 * 
 */
package com.ig.coffeehouse.service;

import java.util.List;

import com.ig.coffeehouse.dto.Customer;
import com.ig.coffeehouse.exception.ServiceException;

/**
 * @author abhisagrawal
 *
 */
public interface CustomerService {

	/**Service method to add new customer
	 * @param customer
	 * @return 
	 * @throws ServiceException 
	 */
	public Customer addCustomer(Customer customer) throws ServiceException;

	/**Method to return registered customers data
	 * @return
	 * @throws ServiceException 
	 */
	public List<Customer> getRegisteredCustomers() throws ServiceException;
	
	
	
}
