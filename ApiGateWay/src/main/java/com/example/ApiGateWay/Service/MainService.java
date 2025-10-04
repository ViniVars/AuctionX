package com.example.ApiGateWay.Service;

import main_ms.*;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class MainService {


    @GrpcClient("MainServiceClient")
    private MainServiceGrpc.MainServiceBlockingStub mainServiceBlockingStub;

    public UserResponse getSUserDetails(UserByIdRequest userByIdRequest){
        return  mainServiceBlockingStub.getUserDetails(userByIdRequest);
    }

    public UserHistoryResponse getSUserHistory(UserByIdRequest userByIdRequest){
        return mainServiceBlockingStub.getUserHistory(userByIdRequest);
    }

    public UserResponse checkSUserLogin(LoginRequest loginRequest){
        return mainServiceBlockingStub.checkUserLogin(loginRequest);
    }

    public UserResponse checkSUserSignIn(CreateUserRequest createUserRequest){
        return mainServiceBlockingStub.createUser(createUserRequest);
    }

    public BidResponse getSBidDetails(BidByIdRequest bidByIdRequest){
        return mainServiceBlockingStub.getBidDetails(bidByIdRequest);
    }

    public BidHistoryResponse getSBidHistory(BidByIdRequest bidByIdRequest){
        return mainServiceBlockingStub.getBidHistory(bidByIdRequest);
    }
}
