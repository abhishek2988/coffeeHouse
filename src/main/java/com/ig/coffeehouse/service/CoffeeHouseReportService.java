/**
 * 
 */
package com.ig.coffeehouse.service;

import com.ig.coffeehouse.dto.CoffeeHouseReportDTO;
import com.ig.coffeehouse.exception.ServiceException;

/**
 * @author abhisagrawal
 *
 */

public interface CoffeeHouseReportService {

	
	/**Service method to generate report
	 * @return
	 * @throws ServiceException 
	 */
	public CoffeeHouseReportDTO getReport() throws ServiceException;
	
}
