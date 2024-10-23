package com.project.shopper.repository;


import com.project.shopper.model.Inventory;
import com.project.shopper.model.InventoryLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface InventoryLogRepository extends JpaRepository<InventoryLog, Long> {

}
