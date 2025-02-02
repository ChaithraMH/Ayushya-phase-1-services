package com.ayusha.products.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ayusha.products.service.entity.MakeEntity;

/**
 * 
 * @author Finch Date : 01-Aug-2019 Product Model class Defines the methods for
 *         the product management persistance CRUD operations
 *
 */

@Component
@Repository
public interface IMakeRepository extends CrudRepository<MakeEntity, Integer> {

	@Query("SELECT t FROM MakeEntity t WHERE t.id = ?1")
	MakeEntity findMakeById(String id);

	@Query("SELECT t FROM MakeEntity t WHERE t.makeId = ?1")
	MakeEntity findMakeByMakeId(String id);

	@Query("select t FROM MakeEntity t")
	List<MakeEntity> findAllMakes();

	MakeEntity findByName(String name);
}
