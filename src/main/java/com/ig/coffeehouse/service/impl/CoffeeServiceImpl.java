/**
 * 
 */
package com.ig.coffeehouse.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ig.coffeehouse.dto.CoffeeVariety;
import com.ig.coffeehouse.exception.ServiceException;
import com.ig.coffeehouse.repository.CoffeeRepository;
import com.ig.coffeehouse.service.CoffeeService;

/**
 * @author abhisagrawal
 *
 */
@Service
public class CoffeeServiceImpl implements CoffeeService {
	
	@Autowired
	CoffeeRepository coffeeRepo;
	
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(CoffeeServiceImpl.class);
	
	@Override
	public List<CoffeeVariety> addCoffeeVariety(List<CoffeeVariety> coffeeVariety) throws ServiceException {
		
		LOGGER.info("Inside addCoffeeVariety service method");
			
		try {
			for(CoffeeVariety coffeeVar : coffeeVariety) {
				
				CoffeeVariety coffVarFromDb = coffeeRepo.getCoffeeVariety(coffeeVar);//Check if coffee variety already exists
				if (null == coffVarFromDb) {
					coffeeVar.setAvailableServings(coffeeVar.getTotalServings());//If no add it to the in memory db
				} else {

					coffeeVar.setAvailableServings(coffVarFromDb.getAvailableServings() + coffeeVar.getTotalServings());//If variety exist update available servings
					coffeeVar.setTotalServings(coffVarFromDb.getTotalServings() + coffeeVar.getTotalServings());//update total servings

				}

				coffeeRepo.updateCoffeeVariety(coffeeVar);
			}
			return coffeeVariety;
		} catch (Exception e) {
			LOGGER.error("Error Occurred while adding coffee variety",e);
			throw new ServiceException("Error Occurred while adding Coffee Variety",e);
		}

	}

}
