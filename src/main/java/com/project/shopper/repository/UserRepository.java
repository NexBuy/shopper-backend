package com.project.shopper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.shopper.model.ProductUser;

@Repository
public interface UserRepository extends JpaRepository<ProductUser, Long> {
}
