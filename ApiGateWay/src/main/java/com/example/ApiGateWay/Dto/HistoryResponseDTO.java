package com.example.ApiGateWay.Dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryResponseDTO {

    private int histId;
    private LocalDateTime histDate;
    private int bidId;
    private String productName;
    private double bidCost;
    private int userId;
    private String userName;
    private int ownerId;
    private String ownerName;

}
