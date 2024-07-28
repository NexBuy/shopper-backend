package com.project.shopper.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private ProductUser prodcutUser;

    private LocalDateTime orderDate;
    private String status;
    private double totalAmount;

//    @ManyToOne
//    @JoinColumn(name = "payment_id")
//    private Payment payment;

//    @ManyToOne
//    @JoinColumn(name = "shipping_address_id")
//    private Address shippingAddress;

//    @ManyToOne
//    @JoinColumn(name = "billing_address_id")
//    private Address billingAddress;

    @OneToMany(mappedBy = "userOrder")
    private List<OrderItem> orderItems;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

