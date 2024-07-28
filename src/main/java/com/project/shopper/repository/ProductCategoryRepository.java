package com.project.shopper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.shopper.model.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {

}
