package com.ayusha.general.services.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ayusha.general.service.ICountryService;
import com.ayusha.general.services.data.model.CountryDataModel;
import com.ayusha.general.services.entity.CountryEntity;
import com.ayusha.json.utils.JSONConverter;
import com.ayusha.services.common.exceptions.DataPersistenceOperationException;
import com.ayusha.services.common.exceptions.InvalidServiceRequestException;
import com.ayusha.services.common.exceptions.ResourceNotFoundException;
import com.ayusha.services.common.exceptions.ServiceRequestProcessor;
import com.custom.logger.logging.Logger;
import com.custom.logger.manager.LogManager;

/**
 * This is the service api interface. This controls the access to the services
 *
 * @author author1r
 * @version 1.0
 * @since 2019-05-03
 */
@RestController
@RequestMapping("/general/country")
public class CountryServicesController extends ServiceRequestProcessor {

	/** Logger **/
	private static Logger LOG = LogManager.getLogger(CountryServicesController.class);

	/** repository **/
	@Autowired
	private ICountryService iCountryService;

	/**
	 * 
	 * add Country
	 */
	@PostMapping("/add")
	public String addCountry(@RequestBody String requestBody, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws DataPersistenceOperationException, Exception,
			InvalidServiceRequestException, ResourceNotFoundException {
		LOG.info("entered job notes creation - start");
		CountryDataModel countryDataModel = null;
		CountryEntity countryEntity = null;
		int size = 0;
		String strRequestBody = preProcess(requestBody, httpServletRequest, httpServletResponse);

		strRequestBody = postProcess(requestBody, httpServletRequest, httpServletResponse);
		countryDataModel = (CountryDataModel) JSONConverter.convertStringToPOJO(requestBody, CountryDataModel.class);
		countryEntity = new CountryEntity();
		countryEntity.setCountryCode(countryDataModel.getCountryCode());
		countryEntity.setName(countryDataModel.getName());
		iCountryService.save(countryDataModel);
		LOG.info("successfully completed add job notes operation ");
		return JSONConverter.convertPOJOToString(countryDataModel);
	}

	/**
	 * 
	 * update Count
	 */
	@PostMapping("/update")
	public String updateSymptoms(@RequestBody String requestBody, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws DataPersistenceOperationException, Exception,
			InvalidServiceRequestException, ResourceNotFoundException {
		LOG.info("entered job notes creation - start");
		CountryDataModel countryDataModel = null;
		CountryEntity countryEntity = null;
		int size = 0;
		String strRequestBody = preProcess(requestBody, httpServletRequest, httpServletResponse);

		strRequestBody = postProcess(requestBody, httpServletRequest, httpServletResponse);
		countryDataModel = (CountryDataModel) JSONConverter.convertStringToPOJO(requestBody, CountryDataModel.class);
		countryEntity = new CountryEntity();
		countryEntity.setCountryCode(countryDataModel.getCountryCode());
		countryEntity.setName(countryDataModel.getName());
		iCountryService.save(countryDataModel);
		LOG.info("successfully completed add job notes operation ");
		return JSONConverter.convertPOJOToString(countryDataModel);
	}

	/**
	 * find by country code
	 * 
	 */
	@GetMapping("/find")
	public String findCountry(@RequestParam("countryid") String countryid, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws DataPersistenceOperationException, Exception,
			InvalidServiceRequestException, ResourceNotFoundException {
		LOG.info("entered symptoms finding - start");
		return JSONConverter.convertPOJOToString(iCountryService.getCountry(countryid));
	}

	/**
	 * find All
	 * 
	 */
	@GetMapping("/findall")
	public String findCountry(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws DataPersistenceOperationException, Exception, InvalidServiceRequestException,
			ResourceNotFoundException {
		LOG.info("entered symptoms finding - start");
		return JSONConverter.convertPOJOToString(iCountryService.getCountries());
	}
}
