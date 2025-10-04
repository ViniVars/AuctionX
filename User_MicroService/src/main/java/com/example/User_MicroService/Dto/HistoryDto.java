package com.example.User_MicroService.Dto;


import com.example.User_MicroService.Entity.User;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class HistoryDto {

    private String bidId;
    private String productName;
    private Double bidCost;
    private LocalDate histDate;

}
