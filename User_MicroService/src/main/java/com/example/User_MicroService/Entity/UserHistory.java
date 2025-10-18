package com.example.User_MicroService.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "UserProjectionHistory")
public class UserHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int histId;
    private int bidId;
    private String productName;
    private int ownerId;
    private String ownerName;
    @CreationTimestamp
    private LocalDate histDate;
    private int userId;
    private String userName;
    private double bidCost;


}
