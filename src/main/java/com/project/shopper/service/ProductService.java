package com.project.shopper.service;

import com.project.shopper.model.*;
import com.project.shopper.repository.InventoryLogRepository;
import com.project.shopper.repository.InventoryRepository;
import com.project.shopper.repository.ProductRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.apache.coyote.Response;
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

    public ResponseEntity<Product> createProduct(Product product) {
        ResponseEntity<Product> response = new ResponseEntity<>();
        if (productRepository.findProductByName(product.getName()) != null) {
            response.setError("Product with that name already exist");
            return response;
        }
        try {
            response.setPayload(productRepository.save(product));
        }catch(Exception e){
            response.setError("Error: "+ e);
        }
        return response;
    }

    public boolean checkProductInventoryExists(Long productID) {
        return inventoryRepository.findProductExist(productID) == null;
    }

    public Product checkProductExist(Long productId) {
        Optional<Product> productEnt = productRepository.findById(productId);
        return productEnt.orElse(null);
    }

    public ResponseEntity<Inventory> addToInventory(InventoryReq inventoryReq) {
        ResponseEntity<Inventory> response = new ResponseEntity<>();
        Product product = checkProductExist(inventoryReq.getProductId());
        if (product != null) {
            if (checkProductInventoryExists(product.getProductId())) {
                if (inventoryReq.getStock() <= 0) {
                    response.setError("Inventory stock is negative");
                    return response;
                }
                Inventory inventory = new Inventory(product, inventoryReq.getStock());
                response.setPayload(inventoryRepository.save(inventory));
                inventoryReq.setInventoryId(response.getPayload().getInventoryID());
                return response;
            }
            response.setError("Inventory for product already exist");
            return response;
        }
        response.setError("Product does not exist");
        return response;
    }

    public ResponseEntity<List<Inventory>> getAllInventory() {
        ResponseEntity<List<Inventory>> response = new ResponseEntity<>();
        try {
            response.setPayload(inventoryRepository.findAll());
        }catch(Exception e){
            response.setError("Error: "+e);
        }
        return response;
    }

    public ResponseEntity<Inventory> getInventoryForProduct(Long prodId) {
        Optional<Product> product = productRepository.findById(prodId);
        ResponseEntity<Inventory> response = new ResponseEntity<>();
        if(product.isPresent()) {
            try {
                Inventory inventory = inventoryRepository.findProductExist(prodId);
                if(inventory==null){
                    response.setError("Inventory for the product does not exist");
                    return response;
                }
                response.setPayload(inventory);
                return response;
            }catch(Exception e){
                response.setError("Error: "+ e.getMessage());
            }
            return response;
        }
            response.setError("Product does not exist");
            return response;
    }

    public ResponseEntity<Inventory> updateInventory(InventoryReq inventoryReq) {
        ResponseEntity<Inventory> response = new ResponseEntity<>();
        Product product = checkProductExist(inventoryReq.getProductId());
        if (product != null) {
            if (!checkProductInventoryExists(product.getProductId())) {
                if (inventoryReq.getStock() <= 0) {
                    response.setError("Inventory stock is negative");
                    return response;
                }
                Inventory inventory = inventoryRepository.findProductExist(product.getProductId());
                inventory.setQuantity(inventoryReq.getStock());
                inventoryReq.setInventoryId(inventory.getInventoryID());
                response.setPayload(inventoryRepository.save(inventory));
                return response;
            }
            response.setError("Inventory for the product does not exist");
            return response;
        }
        response.setError("Product does not exist");
        return response;
    }

}
