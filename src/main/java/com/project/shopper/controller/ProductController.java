package com.project.shopper.controller;

import com.project.shopper.model.Inventory;
import com.project.shopper.model.InventoryReq;
import com.project.shopper.model.Product;
import com.project.shopper.model.ResponseEntity;
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
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PostMapping("/inventory/add")
    public ResponseEntity<Inventory> addInventory(@RequestBody InventoryReq inventoryReq){
        return productService.addToInventory(inventoryReq);
    }

    @GetMapping("/inventory")
    public ResponseEntity<List<Inventory>> getInventoryForAll(){
        return productService.getAllInventory();
    }

    @GetMapping("/inventory/{prodId}")
    public ResponseEntity<Inventory> getInventoryForProduct(@PathVariable Long prodId){
        return productService.getInventoryForProduct(prodId);
    }

    @PutMapping("/inventory")
    public ResponseEntity<Inventory> updateInventory(@RequestBody InventoryReq inventoryReq){
        return productService.updateInventory(inventoryReq);
    }


}
