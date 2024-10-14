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

}
