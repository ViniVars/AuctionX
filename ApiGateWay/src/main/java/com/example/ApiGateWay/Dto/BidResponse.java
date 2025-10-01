package com.example.ApiGateWay.Dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BidResponse {

    private String bidId;
    private double basePrice;
    private String descp;
    private LocalDate startDate;
    private LocalDate endDate;
    private double finalPrice;
    private String productName;
    private UserResponse userResponse;
    private List<HistoryResponse> myHistory;
    private List<SubscriptionResponse> mySubs;

}
