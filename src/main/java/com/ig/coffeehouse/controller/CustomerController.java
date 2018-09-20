package com.ig.coffeehouse.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ig.coffeehouse.dto.Customer;
import com.ig.coffeehouse.dto.ResponseEnvelopeSuccess;
import com.ig.coffeehouse.service.CustomerService;

import io.swagger.annotations.ApiOperation;

/**
 * @author abhisagrawal
 *
 */
@RestController
public class CustomerController extends AbsractRequestController {

	@Autowired
	CustomerService customerService;
	
	@ApiOperation(value = "API to register customer", response = ResponseEnvelopeSuccess.class, tags = "Add/Update customer")
	@RequestMapping(value = "/customer", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEnvelopeSuccess addCustomer(@Valid @RequestBody Customer customer) throws Exception {

		return buildSuccessResponse(customerService.addCustomer(customer));
	}
	
	@ApiOperation(value = "API to get registered customers list", response = ResponseEnvelopeSuccess.class, tags = "Get customers list")
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public ResponseEnvelopeSuccess getRegisteredCustomers() throws Exception {

		return buildSuccessResponse(customerService.getRegisteredCustomers());
	}

}
