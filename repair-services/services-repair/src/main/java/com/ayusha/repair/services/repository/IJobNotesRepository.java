package com.ayusha.repair.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ayusha.repair.services.entity.JobNotesEntity;


/**
 * 
 * @author author1
 * Date : 01-Aug-2019
 * Ticket Model class
 * Defines the methods for the ticketmanagement persistance CRUD operations
 *
 */
@Component
@Repository
public interface IJobNotesRepository extends CrudRepository<JobNotesEntity,Integer>  {
      
    @Query("SELECT t FROM JobNotesEntity t WHERE t.job_id = ?1")
    JobNotesEntity findJobNotesById(String jobId); 
}
