/**
 * 
 */
package com.ig.coffeehouse.dto;

import java.util.List;

/**
 * @author abhisagrawal
 *
 */
public class CoffeeHouseReportDTO {
	
	private List<DailyReport> dailyReport;

	/**
	 * @return the dailyReport
	 */
	public List<DailyReport> getDailyReport() {
		return dailyReport;
	}

	/**
	 * @param dailyReport the dailyReport to set
	 */
	public void setDailyReport(List<DailyReport> dailyReport) {
		this.dailyReport = dailyReport;
	}

	@Override
	public String toString() {
		return "CoffeeHouseReportDTO [dailyReport=" + dailyReport + "]";
	}
	
}
