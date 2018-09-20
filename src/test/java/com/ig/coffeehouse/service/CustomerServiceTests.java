package com.ig.coffeehouse.service;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.ig.coffeehouse.common.TestCommon;
import com.ig.coffeehouse.dto.Customer;
import com.ig.coffeehouse.service.impl.CustomerServiceImpl;

/**
 * @author abhisagrawal
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTests extends TestCommon {

	@Mock
	CustomerServiceImpl customerServiceImpl;
	
	@Before
	public void initializeMock() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**Test case for add customer service method
	 * @throws Exception
	 */
	@Test
	public void getReportServiceTest() throws Exception{
		
		Customer customerJson = getCustomerJson();
		customerServiceImpl.addCustomer(customerJson);
		verify(customerServiceImpl).addCustomer(customerJson);
	}
	
}
