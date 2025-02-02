package com.ayusha.job.inventory.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ayusha.job.inventory.services.entity.PartIssuedEntity;
import com.ayusha.job.inventory.services.entity.PartRequestedEntity;

/**
 * 
 * @author author1 Date : 01-Aug-2019 Ticket Model class Defines the methods for
 *         the ticketmanagement persistance CRUD operations
 *
 */
public interface IPartsRequestedRepository extends CrudRepository<PartRequestedEntity, Integer> {

	@Query("SELECT t FROM PartRequestedEntity t WHERE t.jobId = ?1")
	List<PartRequestedEntity> findAllRequestedItemsByJobId(String jobId);

	@Query("delete FROM PartRequestedEntity t WHERE t.jobId = ?1")
	void deleteRequestedItemsByJobId(String jobId);

	PartRequestedEntity findByJobId(String jobId);

}
