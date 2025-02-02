package com.ayusha.products.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ayusha.products.service.entity.SymptomEntity;
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
public interface ISymptomRepository extends CrudRepository<SymptomEntity,Integer>{

	 @Query("SELECT t FROM SymptomEntity t WHERE t.symptomId = ?1")
	 SymptomEntity findSymptomById(String productId);
}
