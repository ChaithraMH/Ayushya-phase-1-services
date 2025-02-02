package com.ayusha.repair.service;

import java.util.List;

import com.ayusha.repair.services.data.models.FaultyItemDataModel;
import com.ayusha.repair.services.data.models.FaultyItemsDataModel;
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
public interface IRepairFaultyItemsService {
	
	/**
	 * add ticket
	 */
	public FaultyItemDataModel save(FaultyItemDataModel faultyItemDataModel) throws DataPersistenceOperationException,InvalidServiceRequestException;
		
	/** find job notes by id **/
	public FaultyItemsDataModel getFaultyItemsDataModel(String jobId) throws DataPersistenceOperationException,InvalidServiceRequestException,ResourceNotFoundException,Exception;
	
	/** find job notes by id **/
	public List<FaultyItemDataModel> getFaultyItems(String jobId) throws DataPersistenceOperationException,InvalidServiceRequestException,ResourceNotFoundException,Exception;
	
	/**
	 * add ticket
	 */
	public void deleteFaultyItems(String jobId) throws DataPersistenceOperationException,InvalidServiceRequestException;
	
	/**
	 * add ticket
	 */
	public void updateFaultyItems(FaultyItemsDataModel faultyItemsDataModel) throws DataPersistenceOperationException,InvalidServiceRequestException;
	
	
}

