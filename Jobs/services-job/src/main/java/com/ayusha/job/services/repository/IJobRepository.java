package com.ayusha.job.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ayusha.job.services.entity.JobEntity;
import com.ayusha.job.specification.JobSpecification;

/**
 * 
 * @author Finch Date : 01-Aug-2019 Job Model class Defines the methods for the
 *         job management persistance CRUD operations
 *
 */
public interface IJobRepository extends JpaRepository<JobEntity, Integer>, JpaSpecificationExecutor<JobEntity> {

	@Query("SELECT t FROM JobEntity t WHERE t.jobId = ?1")
	JobEntity findJobByJobId(String jobId);

	@Query("SELECT t FROM JobEntity t WHERE t.userId = ?1")
	List<JobEntity> findJobByUserId(String userId);

	@Query("SELECT t FROM JobEntity t WHERE t.customerId = :customerId and t.status=:status")
	JobEntity findJobBycustomerIdAndStatus(@Param("customerId") String customerId, @Param("status") String statusId);

//	@Query("SELECT t FROM JobEntity t WHERE t.status = ?1")
//	List<JobEntity> findByStatus(String statusId);

	@Query("SELECT t FROM JobEntity t WHERE t.ticketId = ?1")
	List<JobEntity> findByTicketId(String ticketId);

	@Query("SELECT t FROM JobEntity t WHERE t.ticketId = ?1")
	JobEntity checkTicketId(String ticketId);

	@Query("SELECT t FROM JobEntity t WHERE t.id = ?1")
	JobEntity findBySeriesId(long id);

	JobEntity findByStatusAndTicketId(String status, String ticketId);

	JobEntity findByStatus(String statusId);

}
