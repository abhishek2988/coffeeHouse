package com.ig.coffeehouse.controller;

import static org.junit.Assert.assertNotNull;

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
import com.ig.coffeehouse.dto.CoffeeHouseReportDTO;
import com.ig.coffeehouse.dto.ResponseEnvelopeSuccess;
import com.ig.coffeehouse.service.CoffeeHouseReportService;

/**
 * @author abhisagrawal
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CoffeeHouseReportControllerTests extends TestCommon {

	@InjectMocks
	CoffeeHouseReportController coffeeHouseReportController;

	@Mock
	private HttpServletRequest request;

	@Mock
	private HttpServletResponse response;

	@Mock
	CoffeeHouseReportService coffeeHouseReportService;

	@Before
	public void initializeMock() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test case to get daily reports controller method
	 * 
	 * @throws Exception
	 */
	@Test
	public void gerReportTest() throws Exception {

		CoffeeHouseReportDTO dailyReportResponseJson = getDailyReportResponseJson();
		Mockito.doReturn(dailyReportResponseJson).when(coffeeHouseReportService).getReport();

		ResponseEnvelopeSuccess report = coffeeHouseReportController.getReport();

		assertNotNull(report);

	}

	/**
	 * Test case for get report exception case
	 * 
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void gerReportExceptionTest() throws Exception {

		Mockito.when(coffeeHouseReportService.getReport()).thenThrow(Exception.class);

		coffeeHouseReportController.getReport();

	}

}
