package com.ayusha.repair.service.validations;

import org.springframework.stereotype.Component;

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
public class SymptomsDataValidation {
	
	/** LOGGER **/
	private static Logger LOG = LogManager.getLogger(SymptomsDataValidation.class);
	
	/**
	 * default constructor
	 */
	public SymptomsDataValidation() {
		
	}
	
	/**
	 * validate
	 */
	public boolean validate(SymptomDataModel symptomDataModel) throws InvalidServiceRequestException{
		
		if(symptomDataModel==null) {
			throw new InvalidServiceRequestException("Invalid service request data");
		}else if(symptomDataModel.getJobId()==null || (symptomDataModel.getJobId().trim().length()<1)) {
			throw new InvalidServiceRequestException("Invalid job notes request data");
		}else if(symptomDataModel.getSymptomId()==null || (symptomDataModel.getSymptomId().trim().length()<1)) {
			throw new InvalidServiceRequestException("Invalid issue request data");
		}
		return true;
	}

}
