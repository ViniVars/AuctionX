package com.example.ApiGateWay.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionResponse {

    private String subId;
    private LocalDate subDate;
    private UserResponse userResponse;
    private BidResponse bidResponse;
}
