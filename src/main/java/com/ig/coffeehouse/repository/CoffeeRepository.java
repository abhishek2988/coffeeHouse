package com.ig.coffeehouse.repository;

import org.springframework.stereotype.Repository;
import com.ig.coffeehouse.common.CoffeeHouseInMemoryDbManager;
import com.ig.coffeehouse.dto.CoffeeVariety;

/**
 * @author abhisagrawal
 *
 */
@Repository
public class CoffeeRepository {


	/**Method to return coffee variety object from 
	 * inmemory db
	 * @param coffeeVar
	 * @return
	 */
	public CoffeeVariety getCoffeeVariety(CoffeeVariety coffeeVar) {
		return CoffeeHouseInMemoryDbManager.coffeeMap.get(coffeeVar.getCoffeeName());
	}

	/**Method to add/update coffee variety
	 * @param coffeeVar
	 */
	public void updateCoffeeVariety(CoffeeVariety coffeeVar) {
		CoffeeHouseInMemoryDbManager.coffeeMap.put(coffeeVar.getCoffeeName(), coffeeVar);
	}

}
