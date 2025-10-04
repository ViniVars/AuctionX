package com.example.ApiGateWay.Controller;


import com.example.ApiGateWay.Dto.SubscriptionResponse;
import com.example.ApiGateWay.Dto.UserRequest;
import com.example.ApiGateWay.Dto.filterParams;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/subs")
public class SubscriptionController {

    @GetMapping("/")
    ResponseEntity<List<SubscriptionResponse>> getCBidSubs(
            @RequestParam String bidId,
            @RequestParam String userId,
            @RequestParam(defaultValue = "0") int skip,
            @RequestParam(defaultValue = "20") int limit){
        List<filterParams> filters = new ArrayList<>();
        if(bidId != null) filters.add(new filterParams("bidId", bidId));
        if(userId != null) filters.add(new filterParams("userId", userId));
        return ResponseEntity.ok(getSBidSubs(filters, skip, limit));
    }

    @PostMapping("/bid/{id}")
    ResponseEntity<Boolean> getCBidSubs(@PathVariable("id") String id, @RequestBody UserRequest userRequest){
        return ResponseEntity.ok(getSBidSubs(id, userRequest));
    }

}
