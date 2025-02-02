package com.ayusha.general.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ayusha.general.services.entity.CityEntity;

/**
 * 
 * @author author1 Date : 01-Aug-2019 Ticket Model class Defines the methods for
 *         the ticketmanagement persistance CRUD operations
 *
 */
public interface ICityRepository extends JpaRepository<CityEntity, Integer> {

	@Query("SELECT t FROM CityEntity t WHERE t.cityCode = ?1")
	CityEntity findCityByCityId(String cityId);

	@Query("SELECT t FROM CityEntity t WHERE t.stateCode = ?1")
	List<CityEntity> findCitiesByStateId(String stateCode);

	CityEntity findByCityCode(String cityCode);

//	List<CityEntity> findByStateCode(String stateCode);
	
	List<CityEntity> findByStateCode(String stateCode);
	
//	CityEntity findAllName();
}
