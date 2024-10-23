package com.project.shopper.helper;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.project.shopper.model.InventoryLog;
import com.project.shopper.model.InventoryReq;
import com.project.shopper.repository.InventoryLogRepository;
import com.project.shopper.service.ProductService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class InventoryHelper {

    @Autowired
    InventoryLogRepository inventoryLogRepository;

    public InventoryLog addInventoryLogs(InventoryReq inventoryReq){

        InventoryLog inventoryLog = new InventoryLog("A1",inventoryReq.getInventoryId(),"Added inventory - "+ inventoryReq.getStock());
        return inventoryLogRepository.save(inventoryLog);
    }

    public InventoryLog addUpdateInventoryLogs(InventoryReq inventoryReq){
        InventoryLog inventoryLog = new InventoryLog("A1",inventoryReq.getInventoryId(),"Updated inventory - "+ inventoryReq.getStock());
        return inventoryLogRepository.save(inventoryLog);
    }


    @Before("execution(* com.project.shopper.service.ProductService.addToInventory(..)) && args(inventoryReq)")
    private void inventoryAddedService(JoinPoint joinPoint, InventoryReq inventoryReq){
        System.out.println("Inventory ADD request for product: " + inventoryReq.getProductId());
    }

    @After("execution(* com.project.shopper.service.ProductService.addToInventory(..)) && args(inventoryReq)")
    private void inventoryAddedLaterService(JoinPoint joinPoint, InventoryReq inventoryReq){
        System.out.println("Inventory Log ADD: "+addInventoryLogs(inventoryReq).toString());

    }

    @Before("execution(* com.project.shopper.service.ProductService.updateInventory(..)) && args(inventoryReq)")
    private void inventoryUpdatedPreService(JoinPoint joinPoint, InventoryReq inventoryReq){
        System.out.println("Inventory UPDATE request for product: " + inventoryReq.getProductId());
    }

    @After("execution(* com.project.shopper.service.ProductService.updateInventory(..)) && args(inventoryReq)")
    private void inventoryUpdatedLaterService(JoinPoint joinPoint, InventoryReq inventoryReq){
        System.out.println("Inventory Log UPDATE: "+addInventoryLogs(inventoryReq).toString());
    }

}