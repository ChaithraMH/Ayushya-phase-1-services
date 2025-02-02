package com.ayusha.general.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ayusha.general.services.entity.CityEntity;
import com.ayusha.general.services.entity.StateEntity;

/**
 * 
 * @author author1
 * Date : 01-Aug-2019
 * Ticket Model class
 * Defines the methods for the ticketmanagement persistance CRUD operations
 *
 */
public interface IStateRepository extends CrudRepository<StateEntity,Integer>{

	 @Query("SELECT t FROM StateEntity t WHERE t.stateCode = ?1")
	    StateEntity findStateByStateId(String stateCode);
	 @Query("SELECT t FROM StateEntity t WHERE t.countryCode = ?1")
	 List<StateEntity> findStatesByCountryId(String countryCode);

	List<StateEntity> findByCountryCode(String countryCode);
	
	@Query("select t FROM StateEntity t")
	List<StateEntity> findAllStates();
}
