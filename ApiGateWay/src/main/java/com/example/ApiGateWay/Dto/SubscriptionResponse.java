package com.example.ApiGateWay.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionResponse {

    private int subId;
    private LocalDate subDate;
    private int bidId;
    private String productName;
    private LocalDate bidStartDate;
    private int userId;
    private String ownerName;
    private int ownerId;
    private String userName;

}
