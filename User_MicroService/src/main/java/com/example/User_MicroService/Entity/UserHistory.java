package com.example.User_MicroService.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "UserProjectionHistory")
public class UserHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    String histId;
    private String bidId;
    private String bidOwner;
    private String productName;
    private LocalDate histDate = LocalDate.now();
    private String userId;

}
