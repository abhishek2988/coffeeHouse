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
import com.ig.coffeehouse.dto.Customer;
import com.ig.coffeehouse.dto.Order;
import com.ig.coffeehouse.dto.Receipt;
import com.ig.coffeehouse.dto.ResponseEnvelopeSuccess;
import com.ig.coffeehouse.exception.ServiceException;
import com.ig.coffeehouse.service.OrderService;

/**
 * @author abhisagrawal
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTests extends TestCommon {

	@InjectMocks
	OrderController orderController;

	@Mock
	private HttpServletRequest request;

	@Mock
	private HttpServletResponse response;

	@Mock
	OrderService orderService;

	@Before
	public void initializeMock() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test case to add customer controller method
	 * 
	 * @throws Exception
	 */
	@Test
	public void processOrderTest() throws Exception {

		Order orderJson = getOrderJson();
		Receipt receiptJson = getReceiptJson();
		Mockito.doReturn(receiptJson).when(orderService).processOrder(orderJson);
		ResponseEnvelopeSuccess processOrder = orderController.processOrder(orderJson);
		assertNotNull(processOrder);

	}

	/**
	 * Test case for get report exception case
	 * 
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void gerReportExceptionTest() throws Exception {

		Order orderJson = getOrderJson();
		Mockito.doThrow(ServiceException.class).when(orderService).processOrder(orderJson);
		orderController.processOrder(orderJson);

	}

}
