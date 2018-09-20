package com.ig.coffeehouse.repository;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ig.coffeehouse.common.CoffeeHouseInMemoryDbManager;
import com.ig.coffeehouse.dto.CoffeeVariety;
import com.ig.coffeehouse.service.impl.CoffeeHouseReportServiceImpl;

/**
 * @author abhisagrawal
 *
 */
@Repository
public class CoffeeHouseReportRepository {

	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(CoffeeHouseReportRepository.class);
	
	public Map<String,CoffeeVariety> getCoffeeVarietyData() {
		
		LOGGER.info("Inside getCoffeeVarietyData repository method");
		return CoffeeHouseInMemoryDbManager.coffeeMap;
		
	}
	
	
	

}
