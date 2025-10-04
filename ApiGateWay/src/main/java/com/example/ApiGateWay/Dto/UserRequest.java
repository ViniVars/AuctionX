package com.example.ApiGateWay.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private String userName;
    private String phNo;
    private String password;
    private int age;
    private String mail;

}
