package com.example.ApiGateWay.Controller;


import com.example.ApiGateWay.Dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    @GetMapping("/{id}")
    UserResponse getCUserDetails(@PathVariable("id") String id){
        return getSUserDetails(id);
    }

    @GetMapping("/{id}/my-history")
    UserResponse getCUserHistory(@PathVariable("id") String id){
        return getSUserHistory(id);
    }

    @GetMapping("/{id}/my-payments")
    UserResponse getCUserHistory(@PathVariable("id") String id){
        return getSUserPayments(id);
    }

    @PostMapping("/login")
    UserResponse getCUserHistory(@RequestBody UserRequest userRequest){
        return checkSUserLogin(userRequest);
    }

    @PostMapping("/sign-in")
    UserResponse getCUserHistory(@RequestBody UserRequest userRequest){
        return checkSUserSignin(userRequest);
    }
}
