package com.project.shopper.repository;


import com.project.shopper.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    @Query(value = "SELECT * FROM INVENTORY WHERE PRODUCT_ID= ?1",nativeQuery = true)
    public Inventory findProductExist(Long productId);
}
