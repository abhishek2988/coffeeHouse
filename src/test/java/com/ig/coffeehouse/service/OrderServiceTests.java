package com.ig.coffeehouse.service;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.ig.coffeehouse.common.TestCommon;
import com.ig.coffeehouse.dto.Order;
import com.ig.coffeehouse.service.impl.OrderServiceImpl;

/**
 * @author abhisagrawal
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTests extends TestCommon {

	@Mock
	OrderServiceImpl orderServiceImpl;
	
	@Before
	public void initializeMock() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**Test case for add customer service method
	 * @throws Exception
	 */
	@Test
	public void processOrderServiceTest() throws Exception{
		
		Order orderJson = getOrderJson();
		orderServiceImpl.processOrder(orderJson);
		verify(orderServiceImpl).processOrder(orderJson);
	}
	
}
