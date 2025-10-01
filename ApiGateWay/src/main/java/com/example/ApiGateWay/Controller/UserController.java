package com.example.ApiGateWay.Controller;


import com.example.ApiGateWay.Dto.HistoryResponse;
import com.example.ApiGateWay.Dto.TransactionResponse;
import com.example.ApiGateWay.Dto.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    @GetMapping("/{id}")
    ResponseEntity<UserResponse> getCUserDetails(@PathVariable("id") String id){
        return getSUserDetails(id);
    }

    @GetMapping("/{id}/my-history")
    ResponseEntity<List<HistoryResponse>> getCUserHistory(@PathVariable("id") String id){
        return getSUserHistory(id);
    }

    @GetMapping("/{id}/my-payments")
    ResponseEntity<List<TransactionResponse>> getCUserPayments(@PathVariable("id") String id){
        return getSUserPayments(id);
    }

    @PostMapping("/login")
    ResponseEntity<UserResponse> loginUser(@RequestBody UserRequest userRequest){
        return checkSUserLogin(userRequest);
    }

    @PostMapping("/sign-in")
    ResponseEntity<UserResponse> signInUser(@RequestBody UserRequest userRequest){
        return checkSUserSignin(userRequest);
    }
}
