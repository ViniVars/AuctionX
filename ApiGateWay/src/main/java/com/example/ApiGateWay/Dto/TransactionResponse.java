package com.example.ApiGateWay.Dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {

    private int transId;
    private LocalDate transDate;
    private int bidId;
    private String productName;
    private Double bidCost;
    private int userId;
    private String userName;
    private int ownerId;
    private String ownerName;

}
