package com.ayusha.general.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ayusha.general.services.entity.CountryEntity;

/**
 * 
 * @author author1
 * Date : 01-Aug-2019
 * Ticket Model class
 * Defines the methods for the ticketmanagement persistance CRUD operations
 *
 */
public interface ICountryRepository extends CrudRepository<CountryEntity,Integer>{

	 @Query("SELECT t FROM CountryEntity t WHERE t.countryCode = ?1")
	    CountryEntity findCountryByIdId(String jobId);
	 @Query("SELECT t FROM CountryEntity t")
	 List<CountryEntity> findAllCountries();
}
