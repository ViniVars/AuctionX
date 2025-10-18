package com.example.ApiGateWay.Controller;



import com.example.ApiGateWay.Dto.HistoryResponseDTO;
import com.example.ApiGateWay.Dto.UserRequestDTO;
import com.example.ApiGateWay.Dto.UserResponseDTO;
import com.example.ApiGateWay.Mapper.HistoryMapper;
import com.example.ApiGateWay.Mapper.UserMapper;
import com.example.ApiGateWay.Service.UserService;
import user_ms.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    ResponseEntity<UserResponseDTO> getCUserDetails(@PathVariable("userId") int userId){
        UserByIdRequest userByIdRequest = UserByIdRequest.newBuilder().setUserId(userId).build();
        UserResponseDTO userResponseDTO = UserMapper.toDTO(userService.getSUserDetails(userByIdRequest));
        System.out.println("COntroller " + userResponseDTO);
        return ResponseEntity.ok(userResponseDTO);
    }

    @GetMapping("/{userId}/my-history")
    ResponseEntity<List<HistoryResponseDTO>> getCUserHistory(@PathVariable("userId") int userId){
        UserByIdRequest userByIdRequest = UserByIdRequest.newBuilder().setUserId(userId).build();
        List<HistoryResponseDTO> historyResponseDTO = HistoryMapper.toDTOList(userService.getSUserHistory(userByIdRequest));
        return ResponseEntity.ok(historyResponseDTO);
    }


    @PostMapping("/login")
    ResponseEntity<UserResponseDTO> loginUser(@RequestBody UserRequestDTO userRequestDTO){
        LoginRequest loginRequest = LoginRequest.newBuilder().setUserName(userRequestDTO.getUserName()).setPassword(userRequestDTO.getPassword()).build();
        UserResponseDTO userResponseDTO = UserMapper.toDTO(userService.checkSUserLogin(loginRequest));
        return ResponseEntity.ok(userResponseDTO);
    }

    @PostMapping("/sign-in")
    ResponseEntity<UserResponseDTO> signInUser(@RequestBody UserRequestDTO userRequestDTO){
        CreateUserRequest createUserRequest = UserMapper.toProto(userRequestDTO);
        UserResponseDTO userResponseDTO = UserMapper.toDTO(userService.checkSUserSignIn(createUserRequest));
        return ResponseEntity.ok(userResponseDTO);
    }
}
