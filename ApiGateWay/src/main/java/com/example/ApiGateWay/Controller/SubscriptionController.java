package com.example.ApiGateWay.Controller;


import com.example.ApiGateWay.Service.UserService;
//import main_ms.BidByIdRequest;
//import main_ms.BoolResponse;
//import main_ms.FilterParam;
//import main_ms.SubRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subs")
public class SubscriptionController {

    private UserService userService;
//    @GetMapping("/")
//    ResponseEntity<AllSubscriptionResponse> getCBidSubs(
//            @RequestParam int bidId,
//            @RequestParam int userId){
//        List<FilterParam> filters = new ArrayList<>();
//        if(bidId != null) filters.add(FilterParam.newBuilder().setKey("bidId").setValue(bidId).build());
//        if(userId != null) filters.add(new FilterParam("userId", userId));
//        return ResponseEntity.ok(getSBidSubs(filters));
//    }

//    @PostMapping("/")
//    ResponseEntity<BoolResponse> getCBidSubs(@RequestBody SubRequest subRequest){
//        return ResponseEntity.ok(mainService.setSBidSub(subRequest));
//    }

}
