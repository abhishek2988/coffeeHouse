/**
 * 
 */
package com.ig.coffeehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ig.coffeehouse.dto.Order;
import com.ig.coffeehouse.dto.Receipt;
import com.ig.coffeehouse.dto.ResponseEnvelopeSuccess;
import com.ig.coffeehouse.service.OrderService;

import io.swagger.annotations.ApiOperation;

/**
 * @author abhisagrawal
 *
 */
@RestController
public class OrderController extends AbsractRequestController {

	@Autowired
	OrderService orderService;
	
	@ApiOperation(value = "API to process order", response = ResponseEnvelopeSuccess.class, tags = "Process order")
	@RequestMapping(value = "/order", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEnvelopeSuccess processOrder(@RequestBody Order order) throws Exception {

		Receipt receipt = orderService.processOrder(order);
		return buildSuccessResponse(receipt);

	}

}
