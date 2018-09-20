/**
 * 
 */
package com.ig.coffeehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ig.coffeehouse.dto.CoffeeVariety;
import com.ig.coffeehouse.dto.ResponseEnvelopeSuccess;
import com.ig.coffeehouse.service.CoffeeService;

import io.swagger.annotations.ApiOperation;

/**
 * @author abhisagrawal
 *
 */
@RestController
public class CoffeeController extends AbsractRequestController{
	
	@Autowired
	CoffeeService coffeeService;
	
	@ApiOperation(value = "API to add coffee variety", response = ResponseEnvelopeSuccess.class, tags = "Add coffee variety")
	@RequestMapping(value="/coffee", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEnvelopeSuccess addCoffeeVariety(@RequestBody List<CoffeeVariety> coffeeVariety) throws Exception {
		
		return buildSuccessResponse(coffeeService.addCoffeeVariety(coffeeVariety));
		
	}
	
	
	
}
