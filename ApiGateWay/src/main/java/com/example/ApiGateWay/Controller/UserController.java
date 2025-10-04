package com.example.ApiGateWay.Controller;


import com.example.ApiGateWay.Dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    @GetMapping("/{id}")
    ResponseEntity<UserResponse> getCUserDetails(@PathVariable("id") String id){
        return ResponseEntity.ok(getSUserDetails(id));
    }

    @GetMapping("/{id}/my-history")
    ResponseEntity<List<HistoryResponse>> getCUserHistory(
            @PathVariable String id,
            @RequestParam(defaultValue = "0") int skip,
            @RequestParam(defaultValue = "20") int limit){
        return ResponseEntity.ok(getSUserHistory(id, skip, limit));
    }


    @PostMapping("/login")
    ResponseEntity<UserResponse> loginUser(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(checkSUserLogin(userRequest));
    }

    @PostMapping("/sign-in")
    ResponseEntity<UserResponse> signInUser(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(checkSUserSignin(userRequest));
    }
}
