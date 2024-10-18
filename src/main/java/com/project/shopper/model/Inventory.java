package com.project.shopper.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="inventory_id")
    private Long inventoryID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="product_id",referencedColumnName = "product_id")
    @JsonIgnore
    private Product product;

    private int quantity;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(insertable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Inventory(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
