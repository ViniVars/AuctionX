package com.example.ApiGateWay.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryResponse {

    private String histId;
    private LocalDate histDate;
    private BidResponse bidResponse;
    private UserResponse userResponse;
}
