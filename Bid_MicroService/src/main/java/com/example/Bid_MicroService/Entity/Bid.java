package com.example.Bid_MicroService.Entity;

import jakarta.persistence.*;
import lombok.*;

import javax.annotation.Nonnull;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "bids")
@AllArgsConstructor
@NoArgsConstructor
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int bidId;
    @Column(nullable = false)
    private String productName;
    private String descp;
    @Column(nullable = false)
    private int ownerId;
    private String ownerName;
    @Column(nullable = false)
    private LocalDate startDate;
    @Column(nullable = false)
    private LocalDate endDate;
    @Column(nullable = false)
    private double basePrice;
    private double finalPrice;
    private LocalDate createdAt;

}
