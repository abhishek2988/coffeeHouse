package com.ig.coffeehouse.service;

import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.ig.coffeehouse.common.TestCommon;
import com.ig.coffeehouse.dto.CoffeeHouseReportDTO;
import com.ig.coffeehouse.dto.CoffeeVariety;
import com.ig.coffeehouse.repository.CoffeeHouseReportRepository;
import com.ig.coffeehouse.service.impl.CoffeeHouseReportServiceImpl;

/**
 * @author abhisagrawal
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CoffeeHouseReportServiceTests extends TestCommon {

	@InjectMocks
	CoffeeHouseReportServiceImpl coffeeHouseReportService;
	
	@Mock
	CoffeeHouseReportRepository coffeeHouseReportRepository;
	
	@Before
	public void initializeMock() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**Test case for get report service method
	 * @throws Exception
	 */
	@Test
	public void getReportServiceTest() throws Exception{
		
		Map<String, CoffeeVariety> coffeeVarietyMapJson = getCoffeeVarietyMapJson();
		Mockito.doReturn(coffeeVarietyMapJson)
	       .when(coffeeHouseReportRepository)
	       .getCoffeeVarietyData();
		
		
		CoffeeHouseReportDTO report = coffeeHouseReportService.getReport();
		assertNotNull(report);
		
	}
	
}
