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
import com.ayusha.repair.service.IRepairNotesService;
import com.ayusha.repair.service.IRepairSymptomsService;
import com.ayusha.repair.services.data.models.JobNotesDataModel;
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
@RequestMapping("/repairs/symptoms")
public class RepairSymptomsServicesController extends ServiceRequestProcessor{
	
	/** Logger **/
	private static Logger LOG = LogManager.getLogger(RepairNotesServicesController.class);
	
	/** repository **/
	@Autowired
	private IRepairSymptomsService iRepairSymptomsService;
	/**
	 * 
	 * 
	 */
	@PostMapping("/add")
	public String addSymptoms(@RequestBody String requestBody,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws DataPersistenceOperationException,Exception,InvalidServiceRequestException,ResourceNotFoundException{
		LOG.info("entered job notes creation - start");
		List<SymptomDataModel> lstSymptomDataModel = null;
		SymptomDataModel symptomDataModel = null;
		SymptomsEntity symptomsEntity = null;
		int size=0;
		String strRequestBody = preProcess(requestBody,httpServletRequest,httpServletResponse);
		
		strRequestBody = postProcess(requestBody,httpServletRequest,httpServletResponse);
		SymptomsDataModel symptomsDataModel = (SymptomsDataModel)JSONConverter.convertStringToPOJO(requestBody, SymptomsDataModel.class);
		
		lstSymptomDataModel = symptomsDataModel.getLstSymptoms();
		size = lstSymptomDataModel.size();
		
		for(int index=0; index<size;index++) {
			symptomDataModel = lstSymptomDataModel.get(index);
			iRepairSymptomsService.save(symptomDataModel);
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
		SymptomsDataModel symptomsDataModel = (SymptomsDataModel)JSONConverter.convertStringToPOJO(requestBody, SymptomsDataModel.class);
		iRepairSymptomsService.updateSymptoms(symptomsDataModel);
		LOG.info("successfully completed add job notes operation ");
		return JSONConverter.convertPOJOToString(symptomsDataModel);
	}
	
	/**
	 * 
	 * 
	 */
	@GetMapping("/find")
	public String findSymptoms(@RequestParam("jobid") String jobid,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws DataPersistenceOperationException,Exception,InvalidServiceRequestException,ResourceNotFoundException{
		LOG.info("entered symptoms finding - start");
		return JSONConverter.convertPOJOToString(iRepairSymptomsService.getSymptomsDataModel(jobid));
	}
}
