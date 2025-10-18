package com.example.User_MicroService.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;


@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int userId;
    private String userName;
    private String password;
    private int age;
    private String mail;
    private String phNo;
    private LocalDate joinDate = LocalDate.now();

}
