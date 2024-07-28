package com.project.shopper.service;

import com.project.shopper.model.Product;
import com.project.shopper.model.ProductCategory;
import com.project.shopper.repository.ProductCategoryRepository;
import com.project.shopper.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryRepository categoryRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product createProduct(Product product){
        categoryRepository.save(product.getProdCategory());
        return productRepository.save(product);
    }
}
