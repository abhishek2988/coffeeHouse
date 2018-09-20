/**
 * 
 */
package com.ig.coffeehouse.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ig.coffeehouse.controller.AbsractRequestController;
import com.ig.coffeehouse.dto.CoffeeHouseReportDTO;
import com.ig.coffeehouse.dto.CoffeeVariety;
import com.ig.coffeehouse.dto.DailyReport;
import com.ig.coffeehouse.exception.ServiceException;
import com.ig.coffeehouse.repository.CoffeeHouseReportRepository;
import com.ig.coffeehouse.service.CoffeeHouseReportService;

/**
 * @author abhisagrawal
 *
 */
@Service
public class CoffeeHouseReportServiceImpl implements CoffeeHouseReportService {

	@Autowired
	CoffeeHouseReportRepository coffeeHouseReportRepo;
	
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(CoffeeHouseReportServiceImpl.class);
	
	@Override
	public CoffeeHouseReportDTO getReport() throws ServiceException {
		
		LOGGER.info("Inside getReport service method");
		CoffeeHouseReportDTO coffeeReport = new CoffeeHouseReportDTO();
		try {
			Map<String,CoffeeVariety> coffeeVar = coffeeHouseReportRepo.getCoffeeVarietyData();
			List<DailyReport> dailyReportList = new ArrayList<>();
			DailyReport dailyReportObj;
			for(String s : coffeeVar.keySet()) {
				
				dailyReportObj = new DailyReport();
				
				dailyReportObj.setCoffeeVariety(coffeeVar.get(s).getCoffeeName());
				dailyReportObj.setTotalServings(coffeeVar.get(s).getTotalServings());
				dailyReportObj.setTotalServingsSold(coffeeVar.get(s).getTotalServings()-coffeeVar.get(s).getAvailableServings());
				dailyReportList.add(dailyReportObj);
				
			}
			coffeeReport.setDailyReport(dailyReportList);
		} catch (Exception e) {
			LOGGER.error("Error occurred while getting daily report");
			throw new ServiceException("Error occurred while getting daily report",e);
		}
		
		return coffeeReport;
	}

}
