package com.project.shopper.model;


public class InventoryReq {



    private Long InventoryId;
    private Long ProductId;
    private int stock;

    public Long getProductId() {
        return ProductId;
    }

    public void setProductId(Long productId) {
        ProductId = productId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    public Long getInventoryId() {
        return InventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        InventoryId = inventoryId;
    }

}
