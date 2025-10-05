package com.example.ApiGateWay.Service;

import com.google.protobuf.Empty;
import main_ms.*;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;


public class MainService {


    @GrpcClient("MainServiceClient")
    private MainServiceGrpc.MainServiceBlockingStub mainServiceBlockingStub;

//   User MS

    public UserResponse getSUserDetails(UserByIdRequest userByIdRequest){
        return  mainServiceBlockingStub.getUserDetails(userByIdRequest);
    }

    public UserHistoryResponse getSUserHistory(UserByIdRequest userByIdRequest){
        return mainServiceBlockingStub.getUserHistory(userByIdRequest);
    }

    public BoolResponse checkSUserLogin(LoginRequest loginRequest){
        return mainServiceBlockingStub.checkUserLogin(loginRequest);
    }

    public BoolResponse checkSUserSignIn(CreateUserRequest createUserRequest){
        return mainServiceBlockingStub.createUser(createUserRequest);
    }

//    Bid MS

    public BidResponse getSBidDetails(BidByIdRequest bidByIdRequest){
        return mainServiceBlockingStub.getBidDetails(bidByIdRequest);
    }

    public BidHistoryResponse getSBidHistory(BidByIdRequest bidByIdRequest){
        return mainServiceBlockingStub.getBidHistory(bidByIdRequest);
    }

    public BoolResponse setSBidDetails(CreateBidRequest createBidRequest){
        return mainServiceBlockingStub.createBid(createBidRequest);
    }

    public AllBidResponse getSAllBids(){
        return mainServiceBlockingStub.getAllBidDetails(Empty.getDefaultInstance());
    }

//    Sub MS

    public AllSubResponse getSAllSubs(SubByIdRequest subByIdRequest){
        return mainServiceBlockingStub.getAllSubDetails(subByIdRequest);
    }

    public BoolResponse setSBidSub(SubRequest subRequest){
        return mainServiceBlockingStub.setBidSub(subRequest);
    }
}
