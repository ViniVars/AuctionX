package com.example.ApiGateWay.Controller;



import com.example.ApiGateWay.Service.MainService;
import com.sun.tools.javac.Main;
import main_ms.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bids")
public class BidController {

    private MainService mainService;

    @GetMapping("/")
    ResponseEntity<AllBidResponse> getCAllBids(){
        return ResponseEntity.ok(mainService.getSAllBids());
    }

    @GetMapping("/{id}")
    ResponseEntity<BidResponse> getCBidDetails(@PathVariable int bidId){
        BidByIdRequest bidByIdRequest = BidByIdRequest.newBuilder().setBidId(bidId).build();
        return ResponseEntity.ok(mainService.getSBidDetails(bidByIdRequest));
    }

    @GetMapping("/{id}/my-history")
    ResponseEntity<BidHistoryResponse> getCBidHistory(@PathVariable int bidId){
        BidByIdRequest bidByIdRequest = BidByIdRequest.newBuilder().setBidId(bidId).build();
        return ResponseEntity.ok(mainService.getSBidHistory(bidByIdRequest));
    }

    @PostMapping("/")
    ResponseEntity<BoolResponse> setCBidDetails(@RequestBody CreateBidRequest createBidRequest){
        return ResponseEntity.ok(mainService.setSBidDetails(createBidRequest));
    }

}
