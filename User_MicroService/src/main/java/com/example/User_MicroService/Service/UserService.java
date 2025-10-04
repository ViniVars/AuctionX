package com.example.User_MicroService.Service;


import com.example.User_MicroService.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
public class UserService {

    @Autowired
    UserRepo userRepo;


}
