package com.example.ApiGateWay.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String userId;
    private String userName;
    private String phNo;
    private int age;
    private String mail;
    private LocalDate joinDate;
    private List<HistoryResponse> myHistory;
    private List<TransactionResponse> myPayments;
    private List<SubscriptionResponse> mySubs;

}
