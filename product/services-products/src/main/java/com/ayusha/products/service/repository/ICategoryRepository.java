package com.ayusha.products.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ayusha.products.service.entity.CategoryEntity;

/**
 * 
 * @author Finch Date : 01-Aug-2019 Product Model class Defines the methods for
 *         the product management persistance CRUD operations
 *
 */
@Component
@Repository
public interface ICategoryRepository extends CrudRepository<CategoryEntity, Integer> {

	@Query("SELECT t FROM CategoryEntity t WHERE t.id = ?1")
	CategoryEntity findCategoryById(String id);

	@Query("select t FROM CategoryEntity t")
	List<CategoryEntity> findAllCategories();

	@Query("SELECT t FROM CategoryEntity t WHERE t.categoryId = :categoryId")
	CategoryEntity findCategoryByCategoryId(@Param("categoryId") String categoryId);

	CategoryEntity findByName(String name);
}
