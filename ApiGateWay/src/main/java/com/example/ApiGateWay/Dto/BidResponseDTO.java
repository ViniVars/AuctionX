package com.example.ApiGateWay.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BidResponseDTO {

    private int bidId;
    private String productName;
    private int ownerId;
    private String descp;
    private LocalDate startDate;
    private LocalDate endDate;
    private double basePrice;
    private double finalPrice;
    private LocalDate bidRegisterDate;

}
