package com.ayusha.job.inventory.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ayusha.job.inventory.services.entity.PartIssuedEntity;
import com.ayusha.job.inventory.services.entity.PartReturnedEntity;

/**
 * 
 * @author author1 Date : 01-Aug-2019 Ticket Model class Defines the methods for
 *         the ticketmanagement persistance CRUD operations
 *
 */
public interface IPartsIssuedRepository extends CrudRepository<PartIssuedEntity, Integer> {

	@Query("SELECT t FROM PartIssuedEntity t WHERE t.jobId = ?1")
	List<PartIssuedEntity> findAllIssuedItemsByJobId(String jobId);

	@Query("delete FROM PartIssuedEntity t WHERE t.jobId = ?1")
	void deletePartsIssuedByJobId(String jobId);

	PartIssuedEntity findByJobId(String jobId);
}
