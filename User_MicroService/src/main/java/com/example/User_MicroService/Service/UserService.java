package com.example.User_MicroService.Service;


import com.example.User_MicroService.Entity.User;
import com.example.User_MicroService.Entity.UserHistory;
import com.example.User_MicroService.Repo.UserHistoryRepo;
import com.example.User_MicroService.Repo.UserRepo;
import com.google.protobuf.Timestamp;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import user_ms.UserMsServiceGrpc;


import java.util.List;


@GrpcService
public class UserService extends UserMsServiceGrpc.UserMsServiceImplBase {


    @Autowired
    UserRepo userRepo;

    @Autowired
    UserHistoryRepo userHistoryRepo;

    @Override
    public void getUserDetails(user_ms.UserByIdRequest userByIdRequest, StreamObserver<user_ms.UserResponse> responseObserver) {
        User user = userRepo.findById(userByIdRequest.getUserId())
                        .orElseThrow(() -> new RuntimeException("User not Found"));

        user_ms.UserResponse userResponse = user_ms.UserResponse.newBuilder()
                .setUserId(user.getUserId())
                .setUserName(user.getUserName())
                .setMail(user.getMail())
                .setAge(user.getAge())
                .setPhNo(user.getPhNo())
//                .setJoinDate(Timestamp.newBuilder().setNanos(user.getJoinDate()).build()user.getJoinDate())
                .build();
        responseObserver.onNext(userResponse);
        responseObserver.onCompleted();
    }


    @Override
    public void getUserHistory(user_ms.UserByIdRequest userByIdRequest, StreamObserver<user_ms.UserHistoryResponse> responseObserver) {
        try {
            // Step 1: Fetch all history records for the given userId
            List<UserHistory> userHistoryList = userHistoryRepo.findAllHistoryById(userByIdRequest.getUserId());

            // Step 2: Convert each UserHistory (entity) to HistoryResponse (gRPC object)
            List<user_ms.HistoryResponse> historyResponses = userHistoryList.stream()
                    .map(history -> user_ms.HistoryResponse.newBuilder()
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
            user_ms.UserHistoryResponse allHistoryResponse = user_ms.UserHistoryResponse.newBuilder()
                    .addAllHistoryResponse(historyResponses)
                    .build();

            // Step 4: Send response back
            responseObserver.onNext(allHistoryResponse);
            responseObserver.onCompleted();

        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }


    @Override
    public void checkUserLogin(user_ms.LoginRequest request, StreamObserver<user_ms.UserResponse> responseObserver) {
        user_ms.UserResponse userResponse = userRepo.userLogin(request.getUserName(), request.getPassword());
        if(userResponse != null) {
            responseObserver.onNext(userResponse);
            responseObserver.onCompleted();
        }
        else{
            responseObserver.onError(new RuntimeException("User Not Found"));
        }

    }

    @Override
    public void createUser(user_ms.CreateUserRequest request, StreamObserver<user_ms.UserResponse> responseObserver) {

    }
}
