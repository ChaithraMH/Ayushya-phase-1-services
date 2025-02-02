package com.ayusha.payments.services.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ayusha.payments.services.entity.EstimateEntity;
import com.ayusha.payments.services.entity.EstimateCashReceiptLineItemEntity;
import com.ayusha.payments.services.entity.EstimateOtherChargesEntity;

/**
 * 
 * @author author1
 * Date : 01-Aug-2019
 * Ticket Model class
 * Defines the methods for the ticketmanagement persistance CRUD operations
 *
 */
public interface IEstimationOtherChargesRepository extends CrudRepository<EstimateOtherChargesEntity,Integer>{

//	 @Query("SELECT t FROM EstimateOtherChargesEntity t WHERE t.estimateId = ?1")
//	 EstimateOtherChargesEntity findEstimateOtherChargesEntityByEstimateId(String estimateId);
	
}
