package com.project.shopper.controller;

import com.project.shopper.model.Inventory;
import com.project.shopper.model.InventoryReq;
import com.project.shopper.model.Product;
import com.project.shopper.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    public ProductService productService;

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PostMapping("/inventory/add")
    public Inventory addInventory(@RequestBody InventoryReq inventoryReq){
        return productService.addToInventory(inventoryReq);
    }

    @GetMapping("/inventory")
    public List<Inventory> getInventoryForAll(){
        return productService.getAllInventory();
    }

    @GetMapping("/inventory/{prodId}")
    public Inventory getInventoryForProduct(@PathVariable Long prodId){
        return productService.getInventoryForProduct(prodId);
    }

    @PutMapping("/inventory")
    public Inventory updateInventory(@RequestBody InventoryReq inventoryReq){
        return productService.updateInventory(inventoryReq);
    }


}
