package com.ayusha.products.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ayusha.products.service.entity.ServiceTypeEntity;

/**
 * 
 * @author Finch
 * Date : 01-Aug-2019
 * Product Model class 
 * Defines the methods for the product management persistance CRUD operations
 *
 */
@Component
@Repository
public interface IServiceTypeRepository extends CrudRepository<ServiceTypeEntity,Integer>{

	 @Query("SELECT t FROM ServiceTypeEntity t WHERE t.id = ?1")
	 ServiceTypeEntity findMakeById(String id);
	 @Query("select t FROM ServiceTypeEntity t")
	    List<ServiceTypeEntity> findAllMakes();
}
