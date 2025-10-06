package com.example.User_MicroService.Service;


import com.example.User_MicroService.Repo.UserRepo;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;


@GrpcService
public class UserService {

    @Autowired
    UserRepo userRepo;

//    @Override



}
