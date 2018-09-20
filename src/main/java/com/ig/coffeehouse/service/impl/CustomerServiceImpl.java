/**
 * 
 */
package com.ig.coffeehouse.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ig.coffeehouse.dto.Customer;
import com.ig.coffeehouse.exception.ServiceException;
import com.ig.coffeehouse.repository.CustomerRepository;
import com.ig.coffeehouse.service.CustomerService;

/**
 * @author abhisagrawal
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepo;
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Override
	public Customer addCustomer(Customer customer) throws ServiceException {
		
		LOGGER.info("Inside add customer service method");
		try {
			customerRepo.addCustomer(customer);
		} catch (Exception e) {
			LOGGER.error("Error occurred while adding customer");
			throw new ServiceException("Error occurred while adding customer",e);
		}
		
		return customer;
	}

	@Override
	public List<Customer> getRegisteredCustomers() throws ServiceException {
		
		List<Customer> registeredCustomersList;
		try {
			registeredCustomersList = new ArrayList<>();
			Map<Customer, Customer> registeredCustomers = customerRepo.getRegisteredCustomers();
			
			for(Entry<Customer, Customer> obj : registeredCustomers.entrySet()) {
				
				registeredCustomersList.add(obj.getValue());
			}
		} catch (Exception e) {
			LOGGER.error("Error occurred while fetching registered customer list");
			throw new ServiceException("Error occurred while fetching registered customer list",e);
		}
		
		
		return registeredCustomersList;
	}

}
