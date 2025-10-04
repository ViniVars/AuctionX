package com.example.ApiGateWay.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryResponse {

    private int histId;
    private LocalDate histDate;
    private int bidId;
    private String productName;
    private double bidCost;
    private int userId;
    private String userName;
    private int ownerId;
    private String ownerName;

}
