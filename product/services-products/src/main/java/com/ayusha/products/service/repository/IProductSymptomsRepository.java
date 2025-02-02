package com.ayusha.products.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ayusha.products.service.entity.ProductSymptomsEntity;
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
public interface IProductSymptomsRepository extends CrudRepository<ProductSymptomsEntity,Integer>{

	 @Query("SELECT t FROM ProductSymptomsEntity t WHERE t.productId = ?1")
	 List<ProductSymptomsEntity> findSymptomById(String productId);
	
}