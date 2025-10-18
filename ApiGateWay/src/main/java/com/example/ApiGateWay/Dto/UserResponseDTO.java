package com.example.ApiGateWay.Dto;

import com.google.protobuf.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    private int userId;
    private String userName;
    private String phNo;
    private int age;
    private String mail;
    private LocalDateTime joinDate;

}
