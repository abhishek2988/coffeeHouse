package com.ig.coffeehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ig.coffeehouse.dto.ResponseEnvelopeSuccess;
import com.ig.coffeehouse.service.CoffeeHouseReportService;

import io.swagger.annotations.ApiOperation;

/**
 * @author abhisagrawal
 *
 */
@RestController
public class CoffeeHouseReportController extends AbsractRequestController {

	@Autowired
	CoffeeHouseReportService coffeeHouseReportService;
	
	@ApiOperation(value = "API to generate daily report", response = ResponseEnvelopeSuccess.class, tags = "Get daily report")
	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public ResponseEnvelopeSuccess getReport() throws Exception {

		return buildSuccessResponse(coffeeHouseReportService.getReport());

	}

}
