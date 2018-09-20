package com.ig.coffeehouse.service;

import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.ig.coffeehouse.common.TestCommon;
import com.ig.coffeehouse.dto.CoffeeVariety;
import com.ig.coffeehouse.service.impl.CoffeeServiceImpl;

/**
 * @author abhisagrawal
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CoffeeServiceTests extends TestCommon {

	@Mock
	CoffeeServiceImpl coffeeServiceImpl;
	
	@Before
	public void initializeMock() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**Test case for add customer service method
	 * @throws Exception
	 */
	@Test
	public void addCoffeeVarietyServiceTest() throws Exception{
		
		List<CoffeeVariety> coffeeVarietyJson = getCoffeeVarietyJson();
		coffeeServiceImpl.addCoffeeVariety(coffeeVarietyJson);
		verify(coffeeServiceImpl).addCoffeeVariety(coffeeVarietyJson);
	}
	
}
