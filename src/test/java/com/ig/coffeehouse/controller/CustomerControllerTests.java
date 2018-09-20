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
import com.ig.coffeehouse.dto.ResponseEnvelopeSuccess;
import com.ig.coffeehouse.exception.ServiceException;
import com.ig.coffeehouse.service.CustomerService;

/**
 * @author abhisagrawal
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTests extends TestCommon {

	@InjectMocks
	CustomerController customerController;

	@Mock
	private HttpServletRequest request;

	@Mock
	private HttpServletResponse response;

	@Mock
	CustomerService customerService;

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
	public void addCustomerTest() throws Exception {

		Customer customerJson = getCustomerJson();
		Mockito.doReturn(customerJson).when(customerService).addCustomer(customerJson);
		ResponseEnvelopeSuccess addCustomer = customerController.addCustomer(customerJson);

		assertNotNull(addCustomer);

	}

	/**
	 * Test case for get report exception case
	 * 
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void gerReportExceptionTest() throws Exception {

		Customer customerJson = getCustomerJson();
		Mockito.doThrow(ServiceException.class).when(customerService).addCustomer(customerJson);
		customerController.addCustomer(customerJson);

	}

}
