package com.ayusha.payments.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ayusha.job.specification.EstimateSearchSpecificatoin;
import com.ayusha.json.utils.JSONConverter;
import com.ayusha.payments.data.models.CashReceiptDataModel;
import com.ayusha.payments.data.models.EstimateDataModel;
import com.ayusha.payments.data.models.EstimatesDataModel;
import com.ayusha.payments.services.entity.EstimateEntity;
import com.ayusha.payments.services.repository.IEstimationRepository;
import com.ayusha.services.common.exceptions.DataPersistenceOperationException;
import com.ayusha.services.common.exceptions.InvalidServiceRequestException;
import com.ayusha.services.common.exceptions.ResourceNotFoundException;
import com.custom.logger.logging.Logger;
import com.custom.logger.manager.LogManager;

/**
 * 
 * @author Finch
 * @Date : 01-Aug-2019 Ticket Model class
 * 
 *       1. Recording (single): a. Persisting in DB b. on Success - sending an
 *       email/sms to customer c. assigning service invoking
 * 
 *       2. Update: a. On change of status - sending an email/sms notification
 * 
 *       3. Batch Recording: a. Persisting in DB b. on Success - sending an
 *       email/sms to customer -seggregating and sending an single email c.
 *       assigning service invoking - Individually
 * 
 *       4. Search: a. search based on date, user, customer,logged date,
 *       issue,servicetype,serialnumber
 * 
 *       5. Sorting: a. soring based on logged date,status,servicetype (ASC |
 *       DSC)
 */
@Service
public class EstimateService implements IEstimateService {

	/** LOGGER **/
	private static Logger LOG = LogManager.getLogger(EstimateService.class);

	/** repository **/
	@Autowired
	private IEstimationRepository iEstimationRepository;

	/**
	 * default constructor
	 **/
	public EstimateService() {
		LOG.info("Estimate Service Constructor");
	}

	/** this is generated random number **/
	private int value = 000;

	private String getNextSequenceNumber() {
		value++;
		String seq_num = String.format("%03d", value);
		return seq_num;
	}

	/**
	 * @method save
	 * @param estimateDataModel
	 * @return estimateDataModel
	 */
	@Override
	public EstimateDataModel save(EstimateDataModel estimateDataModel)
			throws DataPersistenceOperationException, InvalidServiceRequestException {
		EstimateEntity estimateEntity = new EstimateEntity();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("ddMMyyHHmmss-");

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		LocalDateTime now = LocalDateTime.now();

		estimateDataModel.setEstimateId("ATAS-EST-" + dateFormat.format(now) + getNextSequenceNumber());
		estimateDataModel.setGeneratedOn(dtf.format(now));
		estimateEntity.setId(Integer.parseInt("" + estimateDataModel.getId()));
		estimateEntity.setEstimateId(estimateDataModel.getEstimateId());
		estimateEntity.setGeneratedOn(estimateDataModel.getGeneratedOn());
		estimateEntity.setJobCode(estimateDataModel.getJobCode());
		estimateEntity.setApprovalStatus(estimateDataModel.getApprovalStatus());
		estimateEntity.setRequestedBy(estimateDataModel.getRequestedBy());
		estimateEntity.setGrandTotal(estimateDataModel.getGrandTotal());
		iEstimationRepository.save(estimateEntity);
		return estimateDataModel;

	}

	/**
	 * 
	 * @method populateEstimateDataModel
	 * @param estimateEntity
	 * @param estimateDataModel
	 * 
	 */
	private void populateEstimateDataModel(EstimateEntity estimateEntity, EstimateDataModel estimateDataModel)
			throws DataPersistenceOperationException, InvalidServiceRequestException {

		estimateDataModel.setId(Integer.parseInt("" + estimateEntity.getId()));
		estimateDataModel.setEstimateId(estimateEntity.getEstimateId());
		estimateDataModel.setJobCode(estimateEntity.getJobCode());
		estimateDataModel.setGeneratedOn(estimateEntity.getGeneratedOn());
		estimateDataModel.setApprovalStatus(estimateEntity.getApprovalStatus());
		estimateDataModel.setRequestedBy(estimateEntity.getRequestedBy());
		estimateDataModel.setGrandTotal(estimateEntity.getGrandTotal());

	}

	/**
	 * @method getEstimateForJobCodeTime
	 * @param jobCode
	 * @return estimatesDataModel
	 */
	@Override
	public EstimatesDataModel getEstimateForJobCodeTime(String jobCode)
			throws DataPersistenceOperationException, InvalidServiceRequestException {

		List<EstimateEntity> lstEstimateEntity = iEstimationRepository.findEstimateForJobCodeTime(jobCode);
		EstimateDataModel estimateDataModel = new EstimateDataModel();
		EstimatesDataModel estimatesDataModel = new EstimatesDataModel();
		EstimateEntity estimateEntity = new EstimateEntity();
		System.out.println(iEstimationRepository.findEstimateForJobCodeTime(jobCode));
		List<EstimateDataModel> lstEstimateDataModel = new ArrayList();

		int size = lstEstimateEntity.size();
		for (int index = 0; index < size; index++) {
			estimateDataModel = new EstimateDataModel();
			estimateEntity = lstEstimateEntity.get(index);
			populateEstimateDataModel(estimateEntity, estimateDataModel);
			lstEstimateDataModel.add(estimateDataModel);
		}
		estimatesDataModel.setLstEstimates(lstEstimateDataModel);
		return estimatesDataModel;
	}

	/**
	 * @method getLastItem
	 * @param jobCode
	 * @return
	 */
	@Override
	public EstimatesDataModel getLastItem(String jobCode)
			throws DataPersistenceOperationException, InvalidServiceRequestException {

		Page<EstimateEntity> page = iEstimationRepository
				.findAll(PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "jobCode")));

		// EstimatesDataModel estimatesDataModel=
		String a = JSONConverter.convertPOJOToString(page.getContent());

		LOG.info("response last item" + a);
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @method getAllEstimates
	 * @return page
	 */
	@Override
	public Page<EstimateEntity> getAllEstimates()
			throws DataPersistenceOperationException, InvalidServiceRequestException {
		Page<EstimateEntity> page = iEstimationRepository
				.findAll(PageRequest.of(0, Integer.MAX_VALUE, Sort.by(Sort.Direction.DESC, "jobCode")));
		return page;
	}

	/**
	 * get By RequestParam
	 */
	public Page<EstimateDataModel> getByRequested(String requestedBy)
			throws DataPersistenceOperationException, InvalidServiceRequestException, ResourceNotFoundException {
		List<EstimateEntity> lstEntities = iEstimationRepository.findByRequestedBy(requestedBy);
		EstimateDataModel estimateDataModel = null;
		List<EstimateDataModel> lstCashReceiptDataModels = new ArrayList<EstimateDataModel>();
		if (lstEntities != null) {
			for (EstimateEntity estimateEntity : lstEntities) {
				estimateDataModel = new EstimateDataModel();
				BeanUtils.copyProperties(estimateEntity, estimateDataModel);
				lstCashReceiptDataModels.add(estimateDataModel);
			}
			Page<EstimateDataModel> paginationResult = new PageImpl<EstimateDataModel>(lstCashReceiptDataModels);
			return paginationResult;
		} else {
			throw new ResourceNotFoundException("Data is not present.");
		}
	}

	/**
	 * get By JobCode
	 */
	public EstimateEntity getEstimateByJobCode(String jobCode)
			throws DataPersistenceOperationException, InvalidServiceRequestException, ResourceNotFoundException {
		EstimateEntity sEntity = iEstimationRepository.findByJobCode(jobCode);
		if (sEntity != null) {
			return sEntity;
		} else {
			throw new ResourceNotFoundException("JobCode not present.");
		}
	}

	/**
	 * 
	 */

	/**
	 * search
	 */
	@Override
	public Page<EstimateDataModel> searchDetails(EstimateSearchSpecificatoin userSpecification) {

		// pageable
		Pageable paging = PageRequest.of(0, Integer.MAX_VALUE);
		List<EstimateEntity> estimateEntities = iEstimationRepository.findAll(userSpecification);

		List<EstimateDataModel> lstEstDataModel = new ArrayList<EstimateDataModel>();

		EstimateDataModel estimateDataModel = null;

		EstimateEntity estimateEntity = null;
		int size = estimateEntities.size();

		for (int index = 0; index < size; index++) {

			List<CashReceiptDataModel> userlst = new ArrayList<CashReceiptDataModel>();
			estimateEntity = new EstimateEntity();
			estimateDataModel = new EstimateDataModel();
			estimateEntity = estimateEntities.get(index);
			estimateDataModel.setApprovalStatus(estimateEntity.getApprovalStatus());
			estimateDataModel.setEstimateId(estimateEntity.getEstimateId());
			estimateDataModel.setGeneratedOn(estimateEntity.getGeneratedOn());
			estimateDataModel.setGrandTotal(estimateEntity.getGrandTotal());
			estimateDataModel.setJobCode(estimateEntity.getJobCode());
			estimateDataModel.setRequestedBy(estimateEntity.getRequestedBy());
			lstEstDataModel.add(estimateDataModel);

		}
		Page<EstimateDataModel> result = new PageImpl<EstimateDataModel>(lstEstDataModel);
		return result;
	}
}
