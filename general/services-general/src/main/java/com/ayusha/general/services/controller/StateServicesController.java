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

import com.ayusha.general.service.IStateService;
import com.ayusha.general.services.data.model.CountryDataModel;
import com.ayusha.general.services.data.model.StateDataModel;
import com.ayusha.general.services.entity.CountryEntity;
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
@RequestMapping("/general/states")
@CrossOrigin
public class StateServicesController extends ServiceRequestProcessor {

	/** Logger **/
	private static Logger LOG = LogManager.getLogger(StateServicesController.class);

	/** repository **/
	@Autowired
	private IStateService iStateService;

	/**
	 * 
	 * add states
	 */
	@PostMapping("/add")
	public String addState(@RequestBody String requestBody, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws DataPersistenceOperationException, Exception,
			InvalidServiceRequestException, ResourceNotFoundException {
		LOG.info("entered job notes creation - start");
		StateDataModel stateDataModel = null;
		StateEntity stateEntity = null;
		int size = 0;
		String strRequestBody = preProcess(requestBody, httpServletRequest, httpServletResponse);

		strRequestBody = postProcess(requestBody, httpServletRequest, httpServletResponse);
		stateDataModel = (StateDataModel) JSONConverter.convertStringToPOJO(requestBody, StateDataModel.class);
		stateEntity = new StateEntity();
		stateEntity.setCountryCode(stateDataModel.getCountryCode());
		stateEntity.setName(stateDataModel.getName());
		iStateService.save(stateDataModel);
		LOG.info("successfully completed add job notes operation ");
		return JSONConverter.convertPOJOToString(stateDataModel);
	}

	/**
	 * 
	 * update states
	 */
	@PostMapping("/update")
	public String updateState(@RequestBody String requestBody, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws DataPersistenceOperationException, Exception,
			InvalidServiceRequestException, ResourceNotFoundException {
		LOG.info("entered job notes creation - start");
		StateDataModel stateDataModel = null;
		StateEntity stateEntity = null;
		int size = 0;
		String strRequestBody = preProcess(requestBody, httpServletRequest, httpServletResponse);

		strRequestBody = postProcess(requestBody, httpServletRequest, httpServletResponse);
		stateDataModel = (StateDataModel) JSONConverter.convertStringToPOJO(requestBody, StateDataModel.class);
		stateEntity = new StateEntity();
		stateEntity.setCountryCode(stateDataModel.getCountryCode());
		stateEntity.setName(stateDataModel.getName());
		iStateService.save(stateDataModel);
		LOG.info("successfully completed add job notes operation ");
		return JSONConverter.convertPOJOToString(stateDataModel);
	}

	/**
	 * find by stateCode
	 * 
	 */
	@GetMapping("/find")
	public String findCountry(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws DataPersistenceOperationException, Exception,
			InvalidServiceRequestException, ResourceNotFoundException {
		LOG.info("entered symptoms finding - start chedddd");
		return JSONConverter.convertPOJOToString(iStateService.getState());
	}

	/**
	 * 
	 * Find all based on country code
	 */
	@GetMapping("/findAll")
	public String findStates(@RequestParam("countrycode") String countryId, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws DataPersistenceOperationException, Exception,
			InvalidServiceRequestException, ResourceNotFoundException {
		LOG.info("entered symptoms finding - start fffffffffff " + countryId);
		return JSONConverter.convertPOJOToString(iStateService.getStates(countryId));
	}
}
