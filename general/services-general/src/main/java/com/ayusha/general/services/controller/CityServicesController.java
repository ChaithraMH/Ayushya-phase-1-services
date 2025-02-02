package com.ayusha.general.services.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ayusha.general.service.ICityService;
import com.ayusha.general.services.data.model.CityDataModel;
import com.ayusha.general.services.data.model.StateDataModel;
import com.ayusha.general.services.entity.CityEntity;
import com.ayusha.general.services.entity.StateEntity;
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
@RequestMapping("/general/city")
@CrossOrigin
public class CityServicesController extends ServiceRequestProcessor {

	/** Logger **/
	private static Logger LOG = LogManager.getLogger(CityServicesController.class);

	/** repository **/
	@Autowired
	private ICityService iCityService;

	/**
	 * add city
	 * 
	 */
	@PostMapping("/add")
	public String addState(@RequestBody String requestBody, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws DataPersistenceOperationException, Exception,
			InvalidServiceRequestException, ResourceNotFoundException {
		LOG.info("entered job notes creation - start");
		CityDataModel cityDataModel = null;

		int size = 0;
		String strRequestBody = preProcess(requestBody, httpServletRequest, httpServletResponse);

		strRequestBody = postProcess(requestBody, httpServletRequest, httpServletResponse);
		cityDataModel = (CityDataModel) JSONConverter.convertStringToPOJO(requestBody, CityDataModel.class);

		iCityService.save(cityDataModel);
		LOG.info("successfully completed add job notes operation ");
		return JSONConverter.convertPOJOToString(cityDataModel);
	}

	/**
	 * 
	 * update City
	 */
	@PostMapping("/update")
	public String updateState(@RequestBody String requestBody, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws DataPersistenceOperationException, Exception,
			InvalidServiceRequestException, ResourceNotFoundException {
		LOG.info("entered job notes creation - start");
		CityDataModel cityDataModel = null;
		CityEntity cityEntity = null;
		int size = 0;
		String strRequestBody = preProcess(requestBody, httpServletRequest, httpServletResponse);

		strRequestBody = postProcess(requestBody, httpServletRequest, httpServletResponse);
		cityDataModel = (CityDataModel) JSONConverter.convertStringToPOJO(requestBody, CityDataModel.class);
		cityEntity = new CityEntity();

		iCityService.updateCity(cityDataModel);
		LOG.info("successfully completed add job notes operation ");
		return JSONConverter.convertPOJOToString(cityDataModel);
	}

	/**
	 * 
	 * find City by CityCode
	 */
	@GetMapping("/find")
	public String findCountry(@RequestParam("citycode") String citycode, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws DataPersistenceOperationException, Exception,
			InvalidServiceRequestException, ResourceNotFoundException {
		LOG.info("entered symptoms finding - start chedddd");
		return JSONConverter.convertPOJOToString(iCityService.getCity(citycode));
	}

	/**
	 * 
	 * Find all City based on stateCode
	 */
	@GetMapping("/findAll")
	public String findStates(@RequestParam("stateCode") String stateCode, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws DataPersistenceOperationException, Exception,
			InvalidServiceRequestException, ResourceNotFoundException {
		LOG.info("entered symptoms finding - start fffffffffff " + stateCode);
		return JSONConverter.convertPOJOToString(iCityService.getCities(stateCode));
	}
}
