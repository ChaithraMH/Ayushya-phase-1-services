package com.ayusha.repair.service.validations;

import org.springframework.stereotype.Component;

import com.ayusha.repair.services.entity.JobNotesEntity;
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
public class JobNotesDataValidation {
	
	/** LOGGER **/
	private static Logger LOG = LogManager.getLogger(JobNotesDataValidation.class);
	
	/**
	 * default constructor
	 */
	public JobNotesDataValidation() {
		
	}
	
	/**
	 * validate
	 */
	public boolean validate(JobNotesEntity jobNotesEntity) throws InvalidServiceRequestException{
		
		if(jobNotesEntity==null) {
			throw new InvalidServiceRequestException("Invalid service request data");
		}else if(jobNotesEntity.getJob_id()==null || (jobNotesEntity.getJob_id().trim().length()<1)) {
			throw new InvalidServiceRequestException("Invalid job notes request data");
		}else if(jobNotesEntity.getNotes()==null || (jobNotesEntity.getNotes().trim().length()<1)) {
			throw new InvalidServiceRequestException("Invalid issue request data");
		}else if(jobNotesEntity.getNotes()==null || (jobNotesEntity.getNotes().trim().length()>5000)) {
			throw new InvalidServiceRequestException("Invalid issue request data");
		}
		return true;
	}

}
