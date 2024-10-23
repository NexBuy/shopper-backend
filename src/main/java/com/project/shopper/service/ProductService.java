package com.project.shopper.service;

import com.project.shopper.model.Inventory;
import com.project.shopper.model.InventoryLog;
import com.project.shopper.model.InventoryReq;
import com.project.shopper.model.Product;
import com.project.shopper.repository.InventoryLogRepository;
import com.project.shopper.repository.InventoryRepository;
import com.project.shopper.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

//    @Autowired
//    private ProductCategoryRepository categoryRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private InventoryLogRepository inventoryLogRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
//        categoryRepository.save(product.getProdCategory());
        return productRepository.save(product);
    }

    public boolean checkProductInventoryExists(Long productID) {
        return inventoryRepository.findProductExist(productID) == null;
    }

    public Product checkProductExist(Long productId) {
        Optional<Product> productEnt = productRepository.findById(productId);
        return productEnt.orElse(null);
    }

    public Inventory addToInventory(InventoryReq inventoryReq) {
        Product product = checkProductExist(inventoryReq.getProductId());
        if (product != null) {
            if (checkProductInventoryExists(product.getProductId())) {
                if (inventoryReq.getStock() <= 0) {
                    return null;
                }
                Inventory inventory = new Inventory(product, inventoryReq.getStock());
                inventory = inventoryRepository.save(inventory);
                inventoryReq.setInventoryId(inventory.getInventoryID());
                return inventory;
            }
        }
        return null;
    }

    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    public Inventory getInventoryForProduct(Long prodId) {
        Optional<Product> product = productRepository.findById(prodId);
        if (product.isPresent()) {
            return inventoryRepository.findProductExist(prodId);
        } else {
            return null;
        }
    }

    public Inventory updateInventory(InventoryReq inventoryReq) {
        Product product = checkProductExist(inventoryReq.getProductId());
        if (product != null) {
            if (!checkProductInventoryExists(product.getProductId())) {
                if (inventoryReq.getStock() <= 0) {
                    return null;
                }
                Inventory inventory = inventoryRepository.findProductExist(product.getProductId());
                inventory.setQuantity(inventoryReq.getStock());
                inventoryReq.setInventoryId(inventory.getInventoryID());
                return inventoryRepository.save(inventory);
            }
        }
        return null;
    }

}
