package com.ayusha.repair.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ayusha.repair.services.entity.FaultyItemEntity;
import com.ayusha.repair.services.entity.JobNotesEntity;

/**
 * 
 * @author author1
 * Date : 01-Aug-2019
 * Ticket Model class
 * Defines the methods for the ticketmanagement persistance CRUD operations
 *
 */
public interface IFaultyItemRepository extends CrudRepository<FaultyItemEntity,Integer>{

	 @Query("SELECT t FROM FaultyItemEntity t WHERE t.job_id = ?1")
	    List<FaultyItemEntity> findAllFaultyItemsByJobId(String jobId);
	 @Query("delete FROM FaultyItemEntity t WHERE t.job_id = ?1")
	    void deleteFaultyItemsByJobId(String jobId);
}
