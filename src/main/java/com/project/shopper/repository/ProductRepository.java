package com.project.shopper.repository;

import com.project.shopper.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.shopper.model.Product;
import org.springframework.data.jpa.repository.Query;


public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM PRODUCT WHERE NAME= ?1",nativeQuery = true)
    public Product findProductByName(String name);
}
