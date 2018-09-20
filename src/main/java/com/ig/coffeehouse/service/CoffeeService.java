package com.ig.coffeehouse.service;

import java.util.List;

import com.ig.coffeehouse.dto.CoffeeVariety;
import com.ig.coffeehouse.exception.ServiceException;

/**
 * @author abhisagrawal
 *
 */
public interface CoffeeService {

	
	/**Service method to add new coffee variety
	 * @param coffeeVariety
	 * @return 
	 * @throws ServiceException 
	 */
	public List<CoffeeVariety> addCoffeeVariety(List<CoffeeVariety> coffeeVariety) throws ServiceException;
	
	
}
