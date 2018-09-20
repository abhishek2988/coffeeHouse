package com.ig.coffeehouse.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.ig.coffeehouse.common.TestCommon;
import com.ig.coffeehouse.dto.CoffeeVariety;
import com.ig.coffeehouse.dto.ResponseEnvelopeSuccess;
import com.ig.coffeehouse.exception.ServiceException;
import com.ig.coffeehouse.service.CoffeeService;

/**
 * @author abhisagrawal
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CoffeeControllerTests extends TestCommon {

	@InjectMocks
	CoffeeController coffeeController;
	
	@Mock
	private HttpServletRequest request;

	@Mock
	private HttpServletResponse response;

	@Mock
	CoffeeService coffeeService;
	
	@Before
	public void initializeMock() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**Test case for add coffee variety controller method
	 * @throws Exception
	 */
	@Test
	public void addCoffeeVarietyTest() throws Exception{
		
		List<CoffeeVariety> coffeeVarList = getCoffeeVarietyJson();
		Mockito.doReturn(coffeeVarList)
	       .when(coffeeService)
	       .addCoffeeVariety(Mockito.any(List.class));
		
		ResponseEnvelopeSuccess addCoffeeVariety = coffeeController.addCoffeeVariety(coffeeVarList);
		
		assertNotNull(addCoffeeVariety);
		assertEquals(addCoffeeVariety.getSuccess(), true);
		
	}
	/**Test case for add coffee variety exception case
	 * @throws Exception
	 */
	@Test(expected = ServiceException.class)
	public void addCoffeeVarietyExceptionTest() throws Exception {
		
		List<CoffeeVariety> coffeeVarList = getCoffeeVarietyJson();
		Mockito.when(coffeeService.addCoffeeVariety(coffeeVarList)).thenThrow(ServiceException.class);
		
		coffeeController.addCoffeeVariety(coffeeVarList);
		
	}
	
	
}
