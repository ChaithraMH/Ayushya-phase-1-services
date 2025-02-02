package com.ayusha.general.service;

import com.ayusha.general.services.data.model.CountriesDataModel;
import com.ayusha.general.services.data.model.CountryDataModel;
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
public interface ICountryService {
	
	/**
	 * add ticket
	 */
	public CountryDataModel save(CountryDataModel countryDataModel) throws DataPersistenceOperationException,InvalidServiceRequestException;
		
	/** find job notes by id **/
	public CountryDataModel getCountry(String countryId) throws DataPersistenceOperationException,InvalidServiceRequestException,ResourceNotFoundException,Exception;
	
	/** find job notes by id **/
	public CountriesDataModel getCountries() throws DataPersistenceOperationException,InvalidServiceRequestException,ResourceNotFoundException,Exception;
}

