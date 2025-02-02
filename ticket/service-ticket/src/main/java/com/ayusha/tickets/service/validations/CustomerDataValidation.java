package com.ayusha.tickets.service.validations;

import org.springframework.stereotype.Component;

import com.ayusha.services.common.exceptions.InvalidServiceRequestException;
import com.ayusha.tickets.entity.CustomerEntity;
import com.custom.logger.logging.Logger;
import com.custom.logger.manager.LogManager;

/**
 * 
 * @author Finch Date : 01-Aug-2019 Ticket Model class Defines the ticket
 *         service data validation methods
 *
 */
@Component
public class CustomerDataValidation {

	/** LOGGER **/
	private static Logger LOG = LogManager.getLogger(CustomerDataValidation.class);

	/**
	 * default constructor
	 */
	public CustomerDataValidation() {

	}

	/**
	 * validate
	 */
	public boolean validate(CustomerEntity customer) throws InvalidServiceRequestException {

		if (customer == null) {
			throw new InvalidServiceRequestException("Invalid service request data");
		} else if (customer.getCustomerId() == null || (customer.getCustomerId().trim().length() < 1)) {
			throw new InvalidServiceRequestException("Invalid customer request data");
		} else if (customer.getEmail() == null || (customer.getEmail().trim().length() < 1)) {
			throw new InvalidServiceRequestException("Invalid issue request data");
		} else if (customer.getContactNumber() == null || (customer.getContactNumber().trim().length() < 1)) {
			throw new InvalidServiceRequestException("Invalid loggedby request data");
		}
//		}else if(customer.getFirstName()==null || (customer.getFirstName().trim().length()<1)) {
//			throw new InvalidServiceRequestException("Invalid productid request data");
//		}
		return true;
	}
}
