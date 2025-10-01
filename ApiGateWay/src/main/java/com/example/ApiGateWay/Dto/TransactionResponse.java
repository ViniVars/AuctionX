package com.example.ApiGateWay.Dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {

    private String transId;
    private Double bidCost;
    private LocalDate transDate;
    private BidResponse bidResponse;
    private UserResponse userResponse;

}
