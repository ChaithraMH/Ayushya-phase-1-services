package com.ayusha.repair.service.validations;

import org.springframework.stereotype.Component;

import com.ayusha.repair.services.data.models.FaultyItemDataModel;
import com.ayusha.repair.services.data.models.SymptomDataModel;
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
public class FaultyItemsDataValidation {
	
	/** LOGGER **/
	private static Logger LOG = LogManager.getLogger(FaultyItemsDataValidation.class);
	
	/**
	 * default constructor
	 */
	public FaultyItemsDataValidation() {
		
	}
	
	/**
	 * validate
	 */
	public boolean validate(FaultyItemDataModel faultyItemDataModel) throws InvalidServiceRequestException{
		
		if(faultyItemDataModel==null) {
			throw new InvalidServiceRequestException("Invalid service request data");
		}else if(faultyItemDataModel.getJobId()==null || (faultyItemDataModel.getJobId().trim().length()<1)) {
			throw new InvalidServiceRequestException("Invalid job notes request data");
		}else if(faultyItemDataModel.getPartId()==null || (faultyItemDataModel.getPartId().trim().length()<1)) {
			throw new InvalidServiceRequestException("Invalid issue request data");
		}else if(faultyItemDataModel.getFaulty()==null || (faultyItemDataModel.getFaulty().trim().length()<1)) {
			throw new InvalidServiceRequestException("Invalid issue request data");
		}
		return true;
	}

}
