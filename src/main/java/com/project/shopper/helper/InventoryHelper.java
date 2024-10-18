package com.project.shopper.helper;

import com.project.shopper.model.InventoryReq;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class InventoryHelper {

    @Before("execution(* com.project.shopper.service.ProductService.addToInventory(..)) && args(inventoryReq)")
    private void inventoryAddedService(JoinPoint joinPoint, InventoryReq inventoryReq){
        System.out.println("Inventory add request for product: " + inventoryReq.getProductId());
    }

    @After("execution(* com.project.shopper.service.ProductService.addToInventory(..)) && args(inventoryReq)")
    private void inventoryAddedLaterService(JoinPoint joinPoint, InventoryReq inventoryReq){
        System.out.println("Inventory Items added: " + inventoryReq.getStock());
    }

}
