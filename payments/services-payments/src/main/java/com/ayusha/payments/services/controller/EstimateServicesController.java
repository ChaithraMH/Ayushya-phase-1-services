package com.ayusha.payments.services.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ayusha.job.specification.EstimateSearchSpecificatoin;
import com.ayusha.job.specification.SearchSpecification;
import com.ayusha.json.utils.JSONConverter;
import com.ayusha.payments.data.models.CashReceiptDataModel;
import com.ayusha.payments.data.models.EstimateDataModel;
import com.ayusha.payments.service.IEstimateService;
import com.ayusha.payments.services.entity.EstimateEntity;
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
@RequestMapping("/payments/estimate")
@CrossOrigin
public class EstimateServicesController extends ServiceRequestProcessor {

	/** Logger **/
	private static Logger LOG = LogManager.getLogger(EstimateServicesController.class);

	/** repository **/
	@Autowired
	private IEstimateService iEstimateService;

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * @method addEstimate
	 * @param requestBody
	 * @return estimateDataModel
	 */
	@PostMapping("/add")
	public String addEstimate(@RequestBody String requestBody, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws DataPersistenceOperationException, Exception,
			InvalidServiceRequestException, ResourceNotFoundException {
		LOG.info("entered job notes creation - start");
		EstimateDataModel estimateDataModel = null;
		int size = 0;
		String strRequestBody = preProcess(requestBody, httpServletRequest, httpServletResponse);

		strRequestBody = postProcess(requestBody, httpServletRequest, httpServletResponse);
		estimateDataModel = (EstimateDataModel) JSONConverter.convertStringToPOJO(requestBody, EstimateDataModel.class);
		iEstimateService.save(estimateDataModel);
		LOG.info("successfully completed add job notes operation ");
		return JSONConverter.convertPOJOToString(estimateDataModel);
	}

	/**
	 * @method findEstimate
	 * @param jobCode
	 * @return getEstimateForJobCodeTime
	 */
	@GetMapping("/get")
	public String findEstimate(@RequestParam("jobCode") String jobCode, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws DataPersistenceOperationException, Exception,
			InvalidServiceRequestException, ResourceNotFoundException {
		return JSONConverter.convertPOJOToString(iEstimateService.getEstimateForJobCodeTime(jobCode));
	}

	/**
	 * 
	 * @method findlast
	 * @param jobCode
	 * @return getLastItem
	 */
	@GetMapping("/getLast")
	public String findlast(@RequestParam("jobCode") String jobCode, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws DataPersistenceOperationException, Exception,
			InvalidServiceRequestException, ResourceNotFoundException {

		return JSONConverter.convertPOJOToString(iEstimateService.getLastItem(jobCode));
	}

	/**
	 * @method getAllEstimates
	 * @return getAllEstimates
	 */
	@GetMapping("/getAllEstimates")
	public Page<EstimateEntity> getAllEstimates() throws DataPersistenceOperationException, Exception,
			InvalidServiceRequestException, ResourceNotFoundException {
		return iEstimateService.getAllEstimates();
	}

	@GetMapping("/estimateSearch")
	public Page<EstimateDataModel> searchBy(@RequestParam("estimateSearch") String estimateSearch) {
		// call to user specification class
		EstimateSearchSpecificatoin estimateSpecification = new EstimateSearchSpecificatoin(estimateSearch);
		return iEstimateService.searchDetails(estimateSpecification);
	}

}
