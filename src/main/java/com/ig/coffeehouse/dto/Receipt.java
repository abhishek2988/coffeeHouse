/**
 * 
 */
package com.ig.coffeehouse.dto;

import java.util.Date;
import java.util.List;

/**
 * @author abhisagrawal
 *
 */
public class Receipt {

	private String customerName;
	private long phoneNumber;
	private List<CoffeeOrder> coffeeOrdered;
	private Date orderTime;
	
	/**
	 * @return the timeStamp
	 */
	public Date getOrderTime() {
		return orderTime;
	}
	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setOrderTime(Date timeStamp) {
		this.orderTime = timeStamp;
	}
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return the phoneNumber
	 */
	public long getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the coffeeOrdered
	 */
	public List<CoffeeOrder> getCoffeeOrdered() {
		return coffeeOrdered;
	}
	/**
	 * @param coffeeOrdered the coffeeOrdered to set
	 */
	public void setCoffeeOrdered(List<CoffeeOrder> coffeeOrdered) {
		this.coffeeOrdered = coffeeOrdered;
	}
	
	@Override
	public String toString() {
		return "Receipt [customerName=" + customerName + ", phoneNumber=" + phoneNumber + ", coffeeOrdered="
				+ coffeeOrdered + ", orderTime=" + orderTime + "]";
	}
	
	
	
	
}
