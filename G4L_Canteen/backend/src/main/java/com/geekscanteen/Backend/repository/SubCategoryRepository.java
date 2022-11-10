package com.geekscanteen.Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.geekscanteen.Backend.entities.SubCategory;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer>{

	@Query("SELECT count(subcategory) from SubCategory subcategory")
	public Long countOfSubCategory();
	
	@Query("SELECT max(subcategory.subCategoryId) from SubCategory subcategory")
	public int getMaxOfSubCategoryId();
}