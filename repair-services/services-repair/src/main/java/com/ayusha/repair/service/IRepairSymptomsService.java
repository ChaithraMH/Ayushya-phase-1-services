package com.ayusha.repair.service;

import java.util.List;

import com.ayusha.repair.services.data.models.JobNotesDataModel;
import com.ayusha.repair.services.data.models.SymptomDataModel;
import com.ayusha.repair.services.data.models.SymptomsDataModel;
import com.ayusha.services.common.exceptions.DataPersistenceOperationException;
import com.ayusha.services.common.exceptions.InvalidServiceRequestException;
import com.ayusha.services.common.exceptions.ResourceNotFoundException;

/**
 * 
 * @author author1
 * Date : 01-Aug-2019
 * Ticket Model class
 * Defines the ticket service methods
 *
 */
public interface IRepairSymptomsService {
	
	/**
	 * add ticket
	 */
	public SymptomDataModel save(SymptomDataModel symptomDataModel) throws DataPersistenceOperationException,InvalidServiceRequestException;
		
	/** find job notes by id **/
	public SymptomsDataModel getSymptomsDataModel(String jobId) throws DataPersistenceOperationException,InvalidServiceRequestException,ResourceNotFoundException,Exception;
	
	/** find job notes by id **/
	public List<SymptomDataModel> getSymptoms(String jobId) throws DataPersistenceOperationException,InvalidServiceRequestException,ResourceNotFoundException,Exception;
	
	/**
	 * add ticket
	 */
	public void deleteSymptoms(String jobId) throws DataPersistenceOperationException,InvalidServiceRequestException;
	
	/**
	 * add ticket
	 */
	public void updateSymptoms(SymptomsDataModel jobSymptomsDataModel) throws DataPersistenceOperationException,InvalidServiceRequestException;
	
	
}

