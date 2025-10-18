package com.example.ApiGateWay.Service;

import com.example.ApiGateWay.Dto.UserResponseDTO;
import types.AllHistoryResponse;
import user_ms.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private UserMsServiceGrpc.UserMsServiceBlockingStub stub;

    private synchronized void initStub() {
        if (stub == null) {
            ManagedChannel channel = ManagedChannelBuilder
                    .forAddress("user-ms", 9090)  // service hostname + port
                    .usePlaintext()              // no TLS
                    .build();
            stub = UserMsServiceGrpc.newBlockingStub(channel);
        }
    }

//   User MS

    public UserResponse getSUserDetails(UserByIdRequest userByIdRequest) {
        initStub();
        UserResponse userResponse = stub.getUserDetails(userByIdRequest);
        System.out.println("Service : " + userResponse);
        return userResponse;
    }

    public AllHistoryResponse getSUserHistory(UserByIdRequest userByIdRequest) {
        initStub();
        return stub.getUserHistory(userByIdRequest);
    }

    public UserResponse checkSUserLogin(LoginRequest loginRequest) {
        initStub();
        return stub.checkUserLogin(loginRequest);
    }

    public UserResponse checkSUserSignIn(CreateUserRequest createUserRequest) {
        initStub();
        return stub.createUser(createUserRequest);
    }

////    Bid MS
//
//    public BidResponse getSBidDetails(BidByIdRequest bidByIdRequest){
//        initStub();
//        return stub.getBidDetails(bidByIdRequest);
//    }
//
//    public BidHistoryResponse getSBidHistory(BidByIdRequest bidByIdRequest){
//        initStub();
//        return stub.getBidHistory(bidByIdRequest);
//    }
//
//    public BoolResponse setSBidDetails(CreateBidRequest createBidRequest){
//        initStub();
//        return stub.createBid(createBidRequest);
//    }
//
//    public AllBidResponse getSAllBids(){
//        initStub();
//        return stub.getAllBidDetails(Empty.getDefaultInstance());
//    }
//
////    Sub MS
//
//    public AllSubResponse getSAllSubs(SubByIdRequest subByIdRequest){
//        initStub();
//        return stub.getAllSubDetails(subByIdRequest);
//    }
//
//    public BoolResponse setSBidSub(SubRequest subRequest){
//        initStub();
//        return stub.setBidSub(subRequest);
//    }
}
