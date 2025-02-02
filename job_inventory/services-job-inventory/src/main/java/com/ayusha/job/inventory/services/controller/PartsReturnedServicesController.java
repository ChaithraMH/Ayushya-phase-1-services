package com.ayusha.job.inventory.services.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ayusha.job.inventory.data.models.PartReturnedDataModel;
import com.ayusha.job.inventory.data.models.PartsReturnedDataModel;
import com.ayusha.job.inventory.service.IReturnedItemsService;
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
 * @author Finch
 * @version 1.0
 * @since 2019-05-03
 */
@RestController
@RequestMapping("/jobinventory/partsreturned")
public class PartsReturnedServicesController extends ServiceRequestProcessor {

	/** Logger **/
	private static Logger LOG = LogManager.getLogger(PartsReturnedServicesController.class);

	/** repository **/
	@Autowired
	private IReturnedItemsService iReturnedItemsService;

	/**
	 * @method addPartsReturned
	 * @param requestBody
	 * @return requestBody
	 */

	@PostMapping("/add")
	public String addPartsReturned(@RequestBody String requestBody, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws DataPersistenceOperationException, Exception,
			InvalidServiceRequestException, ResourceNotFoundException {
		LOG.info("entered job notes creation - start");
		List<PartReturnedDataModel> lstPartReturnedDataModel = null;
		PartsReturnedDataModel partsReturnedDataModel = null;

		int size = 0;
		String strRequestBody = preProcess(requestBody, httpServletRequest, httpServletResponse);

		strRequestBody = postProcess(requestBody, httpServletRequest, httpServletResponse);
		partsReturnedDataModel = (PartsReturnedDataModel) JSONConverter.convertStringToPOJO(requestBody,
				PartsReturnedDataModel.class);

		iReturnedItemsService.save(partsReturnedDataModel);

		LOG.info("successfully completed add job notes operation ");
		return requestBody;
	}

	/**
	 * @method updatePartReturned
	 * @param requestBody
	 * @return requestBody
	 */
	@PostMapping("/update")
	public String updatePartReturned(@RequestBody String requestBody, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws DataPersistenceOperationException, Exception,
			InvalidServiceRequestException, ResourceNotFoundException {

		List<PartReturnedDataModel> lstPartReturnedDataModel = null;
		PartsReturnedDataModel partsReturnedDataModel = null;

		int size = 0;
		String strRequestBody = preProcess(requestBody, httpServletRequest, httpServletResponse);

		strRequestBody = postProcess(requestBody, httpServletRequest, httpServletResponse);
		partsReturnedDataModel = (PartsReturnedDataModel) JSONConverter.convertStringToPOJO(requestBody,
				PartsReturnedDataModel.class);

		iReturnedItemsService.save(partsReturnedDataModel);

		LOG.info("successfully completed add job notes operation ");
		return requestBody;
	}

	/**
	 * @method findPartsReturned
	 * @param jobid
	 * @return getPartsReturnedDataModel
	 * 
	 */
	@GetMapping("/find")
	public String findPartsReturned(@RequestParam("jobid") String jobid, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws DataPersistenceOperationException, Exception,
			InvalidServiceRequestException, ResourceNotFoundException {
		LOG.info("entered symptoms finding - start");
		// IProductRepository.findAll();
		return JSONConverter.convertPOJOToString(iReturnedItemsService.getPartsReturnedDataModel(jobid));
	}
}
