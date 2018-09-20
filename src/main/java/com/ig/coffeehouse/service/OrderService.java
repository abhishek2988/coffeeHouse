/**
 * 
 */
package com.ig.coffeehouse.service;

import com.ig.coffeehouse.dto.Order;
import com.ig.coffeehouse.dto.Receipt;
import com.ig.coffeehouse.exception.EntityNotFoundException;
import com.ig.coffeehouse.exception.ServiceException;

/**
 * @author abhisagrawal
 *
 */
public interface OrderService {

	/**Service method to process order
	 * @param order
	 * @return 
	 * @throws EntityNotFoundException 
	 * @throws ServiceException 
	 */
	public Receipt processOrder(Order order) throws EntityNotFoundException, ServiceException;
	
}
