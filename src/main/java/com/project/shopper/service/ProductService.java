package com.project.shopper.service;

import com.project.shopper.model.Inventory;
import com.project.shopper.model.InventoryReq;
import com.project.shopper.model.Product;
import com.project.shopper.model.ProductCategory;
import com.project.shopper.repository.InventoryRepository;
import com.project.shopper.repository.ProductCategoryRepository;
import com.project.shopper.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryRepository categoryRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product createProduct(Product product){
//        categoryRepository.save(product.getProdCategory());
        return productRepository.save(product);
    }

    public Inventory addToInventory(InventoryReq inventoryReq) {
        Optional<Product> product = productRepository.findById(inventoryReq.getProductId());
//        if (inventoryRepository. productRepository.existsById(product.get().getProductId())) {
            Inventory inventory = new Inventory(product.get(), inventoryReq.getStock());
//        }
        return inventoryRepository.save(inventory);
    }
}
