package com.project.shopper.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="INVENTORY_LOGS")
public class InventoryLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="inventory_log_id")
    private Long inventoryLogId;

    private String updateType;

    @CreationTimestamp
    private LocalDateTime timestamp;

    private Long relationId;

    private String comments;

    public InventoryLog(String updateType, Long relationId, String comments){
        this.updateType = updateType;
        this.relationId = relationId;
        this.comments = comments;
    }

}
