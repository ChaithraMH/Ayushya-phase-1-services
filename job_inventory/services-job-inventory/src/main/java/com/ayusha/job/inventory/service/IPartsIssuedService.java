package com.ayusha.job.inventory.service;

import java.util.List;

import com.ayusha.job.inventory.data.models.PartIssuedDataModel;
import com.ayusha.job.inventory.data.models.PartsIssuedDataModel;
import com.ayusha.job.inventory.data.models.PartsReturnedDataModel;
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
public interface IPartsIssuedService {
	
	/**
	 * add ticket
	 */
	public PartsIssuedDataModel save(PartsIssuedDataModel partsIssuedDataModel) throws DataPersistenceOperationException,InvalidServiceRequestException;
		
	/** find job notes by id **/
	public PartsIssuedDataModel getPartsIssuedDataModel(String jobId) throws DataPersistenceOperationException,InvalidServiceRequestException,ResourceNotFoundException,Exception;
	
	/** find job notes by id **/
	public List<PartIssuedDataModel> getPartsIssued(String jobId) throws DataPersistenceOperationException,InvalidServiceRequestException,ResourceNotFoundException,Exception;
	
	/**
	 * add ticket
	 */
	public void deletePartsIssued(String jobId) throws DataPersistenceOperationException,InvalidServiceRequestException;
	
	/**
	 * add ticket
	 */
	public PartIssuedDataModel updatePartsIssued(PartIssuedDataModel partsIssuedDataModel) throws DataPersistenceOperationException,InvalidServiceRequestException;
	
	
}

