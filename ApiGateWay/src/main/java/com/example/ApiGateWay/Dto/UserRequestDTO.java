package com.example.ApiGateWay.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {

    private String userName;
    private String phNo;
    private String password;
    private int age;
    private String mail;

}
