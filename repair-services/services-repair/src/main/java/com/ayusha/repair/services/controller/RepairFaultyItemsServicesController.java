package com.ayusha.repair.services.controller;

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

import com.ayusha.json.utils.JSONConverter;
import com.ayusha.repair.service.IRepairFaultyItemsService;
import com.ayusha.repair.services.data.models.FaultyItemDataModel;
import com.ayusha.repair.services.data.models.FaultyItemsDataModel;
import com.ayusha.repair.services.data.models.SymptomDataModel;
import com.ayusha.repair.services.data.models.SymptomsDataModel;
import com.ayusha.repair.services.entity.SymptomsEntity;
import com.ayusha.services.common.exceptions.DataPersistenceOperationException;
import com.ayusha.services.common.exceptions.InvalidServiceRequestException;
import com.ayusha.services.common.exceptions.ResourceNotFoundException;
import com.ayusha.services.common.exceptions.ServiceRequestProcessor;
import com.custom.logger.logging.Logger;
import com.custom.logger.manager.LogManager;

/**
* This is the service api interface.
* This controls the access to the services
*
* @author  author1r
* @version 1.0
* @since   2019-05-03 
*/
@RestController
@RequestMapping("/repairs/faultyitems")
public class RepairFaultyItemsServicesController extends ServiceRequestProcessor{
	
	/** Logger **/
	private static Logger LOG = LogManager.getLogger(RepairFaultyItemsServicesController.class);
	
	/** repository **/
	@Autowired
	private IRepairFaultyItemsService iRepairFaultyItemsService;
	/**
	 * 
	 * 
	 */
	@PostMapping("/add")
	public String addFaultyItems(@RequestBody String requestBody,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws DataPersistenceOperationException,Exception,InvalidServiceRequestException,ResourceNotFoundException{
		LOG.info("entered job notes creation - start");
		List<FaultyItemDataModel> lstFaultyItemsDataModel = null;
		FaultyItemsDataModel faultyItemsDataModel = null;
		FaultyItemDataModel faultyItemDataModel = null;
		SymptomsEntity symptomsEntity = null;
		int size=0;
		String strRequestBody = preProcess(requestBody,httpServletRequest,httpServletResponse);
		
		strRequestBody = postProcess(requestBody,httpServletRequest,httpServletResponse);
		FaultyItemsDataModel symptomsDataModel = (FaultyItemsDataModel)JSONConverter.convertStringToPOJO(requestBody, FaultyItemsDataModel.class);
		
		lstFaultyItemsDataModel = symptomsDataModel.getLstFaultyItems();
		size = lstFaultyItemsDataModel.size();
		
		for(int index=0; index<size;index++) {
			faultyItemDataModel = lstFaultyItemsDataModel.get(index);
			iRepairFaultyItemsService.save(faultyItemDataModel);
		}
		
		LOG.info("successfully completed add job notes operation ");
		return JSONConverter.convertPOJOToString(symptomsDataModel);
	}
	/**
	 * 
	 * 
	 */
	@PostMapping("/update")
	public String updateSymptoms(@RequestBody String requestBody,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws DataPersistenceOperationException,Exception,InvalidServiceRequestException,ResourceNotFoundException{
		
		LOG.info("entered job notes creation - start");
		String strRequestBody = preProcess(requestBody,httpServletRequest,httpServletResponse);
		
		strRequestBody = postProcess(requestBody,httpServletRequest,httpServletResponse);
		FaultyItemsDataModel faultyItemsDataModel = (FaultyItemsDataModel)JSONConverter.convertStringToPOJO(requestBody, FaultyItemsDataModel.class);
		iRepairFaultyItemsService.updateFaultyItems(faultyItemsDataModel);
		LOG.info("successfully completed add job notes operation ");
		return JSONConverter.convertPOJOToString(faultyItemsDataModel);
	}
	
	/**
	 * 
	 * 
	 */
	@GetMapping("/find")
	public String findSymptoms(@RequestParam("jobid") String jobid,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws DataPersistenceOperationException,Exception,InvalidServiceRequestException,ResourceNotFoundException{
		LOG.info("entered symptoms finding - start");
		return JSONConverter.convertPOJOToString(iRepairFaultyItemsService.getFaultyItemsDataModel(jobid));
	}
}
