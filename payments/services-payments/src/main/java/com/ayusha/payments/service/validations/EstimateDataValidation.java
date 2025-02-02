package com.ayusha.payments.service.validations;

import org.springframework.stereotype.Component;

import com.ayusha.payments.data.models.EstimateDataModel;
import com.ayusha.services.common.exceptions.InvalidServiceRequestException;
import com.custom.logger.logging.Logger;
import com.custom.logger.manager.LogManager;

/**
 * 
 * @author author1
 * Date : 01-Aug-2019
 * Ticket Model class
 * Defines the ticket service data validation methods
 *
 */
@Component
public class EstimateDataValidation {
	
	/** LOGGER **/
	private static Logger LOG = LogManager.getLogger(EstimateDataValidation.class);
	
	/**
	 * default constructor
	 */
	public EstimateDataValidation() {
		
	}
	
	/**
	 * validate
	 */
	public boolean validate(EstimateDataModel estimateDataModel) throws InvalidServiceRequestException{
		
		if(estimateDataModel==null) {
			throw new InvalidServiceRequestException("Invalid service request data");
		}else if(estimateDataModel.getJobCode()==null || (estimateDataModel.getJobCode().trim().length()<1)) {
			throw new InvalidServiceRequestException("Invalid job notes request data");
		}
		return true;
	}

}
