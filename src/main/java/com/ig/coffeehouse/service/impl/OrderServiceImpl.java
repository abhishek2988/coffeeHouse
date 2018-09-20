/**
 * 
 */
package com.ig.coffeehouse.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ig.coffeehouse.dto.CoffeeOrder;
import com.ig.coffeehouse.dto.CoffeeVariety;
import com.ig.coffeehouse.dto.Customer;
import com.ig.coffeehouse.dto.Order;
import com.ig.coffeehouse.dto.Receipt;
import com.ig.coffeehouse.exception.EntityNotFoundException;
import com.ig.coffeehouse.exception.ServiceException;
import com.ig.coffeehouse.repository.OrderRepository;
import com.ig.coffeehouse.service.OrderService;

/**
 * @author abhisagrawal
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepo;
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(OrderServiceImpl.class);

	@Override
	public Receipt processOrder(Order order) throws ServiceException {

		try {
			Customer cust = orderRepo.getCustomer(order);

			if (null != cust) {

				for (CoffeeOrder cv : order.getCoffeeVarietyOrdered()) {

					CoffeeVariety coffeeVariety = orderRepo.getCoffeeVariety(cv);

					if (null != coffeeVariety && coffeeVariety.getAvailableServings() >= cv.getQuantity()) {

						coffeeVariety.setAvailableServings(coffeeVariety.getAvailableServings() - cv.getQuantity());
						orderRepo.updateCoffeeVarietyDetails(coffeeVariety);

					} else {

						throw new EntityNotFoundException("Coffee Unavailable");
					}

				}

			} else {
				throw new EntityNotFoundException("Customer not registered");
			}
		} catch (EntityNotFoundException e) {
			LOGGER.error(e.getMessage());
			throw e;
		} catch (Exception e) {
			LOGGER.error("Error occurred while processing the order");
			throw new ServiceException("Error occurred while processing order", e);
		}

		return buildReceipt(order);

	}

	private Receipt buildReceipt(Order order) {

		Receipt receipt = new Receipt();
		receipt.setCustomerName(order.getCustomer().getName());
		receipt.setPhoneNumber(order.getCustomer().getPhoneNumber());
		receipt.setCoffeeOrdered(order.getCoffeeVarietyOrdered());
		receipt.setOrderTime(new Date());

		return receipt;

	}

}
