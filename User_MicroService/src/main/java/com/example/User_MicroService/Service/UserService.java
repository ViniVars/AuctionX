package com.example.User_MicroService.Service;


import com.example.User_MicroService.Entity.User;
import com.example.User_MicroService.Entity.UserHistory;
import com.example.User_MicroService.Repo.UserHistoryRepo;
import com.example.User_MicroService.Repo.UserRepo;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import user_ms.*;

import java.util.List;


@GrpcService
public class UserService extends userMs_ServiceGrpc.userMs_ServiceImplBase {

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserHistoryRepo userHistoryRepo;

    @Override
    public void getSUserDetails(UserByIdRequest userByIdRequest, StreamObserver<UserResponse> responseObserver) {
        User user = userRepo.findById(userByIdRequest.getUserId())
                        .orElseThrow(() -> new RuntimeException("User not Found"));

        UserResponse userResponse = UserResponse.newBuilder()
                .setUserId(user.getUserId())
                .setUserName(user.getUserName())
                .setMail(user.getMail())
                .setAge(user.getAge())
                .build();
        responseObserver.onNext(userResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void getSUserHistory(UserByIdRequest userByIdRequest, StreamObserver<AllHistoryResponse> responseObserver) {
        try {
            // Step 1: Fetch all history records for the given userId
            List<UserHistory> userHistoryList = userHistoryRepo.findAllHistoryById(userByIdRequest.getUserId());

            // Step 2: Convert each UserHistory (entity) to HistoryResponse (gRPC object)
            List<HistoryResponse> historyResponses = userHistoryList.stream()
                    .map(history -> HistoryResponse.newBuilder()
                            .setHistId(history.getHistId())
                            .setBidId(history.getBidId())
                            .setProductName(history.getProductName())
                            .setBidCost(history.getBidCost())
                            .setUserId(history.getUserId())
                            .setUserName(history.getUserName())
                            .setOwnerId(history.getOwnerId())
                            .setOwnerName(history.getOwnerName())
                            .build())
                    .toList();

            // Step 3: Build the final AllHistoryResponse
            AllHistoryResponse allHistoryResponse = AllHistoryResponse.newBuilder()
                    .addAllHistoryResponse(historyResponses)
                    .build();

            // Step 4: Send response back
            responseObserver.onNext(allHistoryResponse);
            responseObserver.onCompleted();

        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

}
