package com.project.shopper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.shopper.model.Product;



public interface ProductRepository extends JpaRepository<Product, Long> {
}
