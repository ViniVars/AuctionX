package com.example.ApiGateWay.Mapper;

import com.example.ApiGateWay.Dto.UserRequestDTO;
import com.example.ApiGateWay.Dto.UserResponseDTO;
import user_ms.CreateUserRequest;
import user_ms.UserResponse;

public class UserMapper {

    public static UserResponseDTO toDTO(UserResponse grpcResponse){
        System.out.println("Mapper : " + grpcResponse);
        return new UserResponseDTO(grpcResponse.getUserId(), grpcResponse.getUserName(), grpcResponse.getPhNo(), grpcResponse.getAge(), grpcResponse.getMail(), LocalDateMapper.toLocalDateTime(grpcResponse.getJoinDate()));
    }

    public static CreateUserRequest toProto(UserRequestDTO userRequestDTO){
        return CreateUserRequest.newBuilder()
                .setAge(userRequestDTO.getAge())
                .setMail(userRequestDTO.getMail())
                .setPhNo(userRequestDTO.getPhNo())
                .setUserName(userRequestDTO.getUserName())
                .setPassword(userRequestDTO.getPassword())
                .build();
    }

}
