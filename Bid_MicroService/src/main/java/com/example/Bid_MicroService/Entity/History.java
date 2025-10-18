package com.example.Bid_MicroService.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int histId;
    @Column(nullable = false)
    private LocalDate histDate;
    @Column(nullable = false)
    private int bidId;
    private String productName;
    @Column(nullable = false)
    double bidCost;
    @Column(nullable = false)
    private int userId;
    private String userName;
    @Column(nullable = false)
    private int ownerId;
    private String ownerName;
    
}
