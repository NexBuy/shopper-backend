package com.project.shopper.controller;

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
    @ResponseBody
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    @ResponseBody
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
}
