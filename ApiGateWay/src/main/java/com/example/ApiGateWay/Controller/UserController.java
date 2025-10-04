package com.example.ApiGateWay.Controller;



import com.example.ApiGateWay.Service.MainService;
import main_ms.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    MainService mainService;

    @GetMapping("/{id}")
    ResponseEntity<UserResponse> getCUserDetails(@PathVariable int userId){
        UserByIdRequest userByIdRequest = UserByIdRequest.newBuilder().setUserId(userId).build();
        return ResponseEntity.ok(mainService.getSUserDetails(userByIdRequest));
    }

    @GetMapping("/{id}/my-history")
    ResponseEntity<UserHistoryResponse> getCUserHistory(@PathVariable int userId){
        UserByIdRequest userByIdRequest = UserByIdRequest.newBuilder().setUserId(userId).build();
        return ResponseEntity.ok(mainService.getSUserHistory(userByIdRequest));
    }


    @PostMapping("/login")
    ResponseEntity<UserResponse> loginUser(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(mainService.checkSUserLogin(loginRequest));
    }

    @PostMapping("/sign-in")
    ResponseEntity<UserResponse> signInUser(@RequestBody CreateUserRequest createUserRequest){
        return ResponseEntity.ok(mainService.checkSUserSignIn(createUserRequest));
    }
}
