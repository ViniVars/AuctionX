package com.example.ApiGateWay.Controller;


import com.example.ApiGateWay.Dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bids")
public class BidController {

    @GetMapping("/")
    ResponseEntity<List<BidResponse>> getCAllBids(){
        return getSAllBids();
    }

    @GetMapping("/{id}")
    ResponseEntity<BidResponse> getCBidDetails(@PathVariable("id") String id){
        return getSBidDetails(id);
    }

    @GetMapping("/{id}/my-subscriptions")
    ResponseEntity<List<SubscriptionResponse>> getCBidSubs(@PathVariable("id") String id){
        return getSBidSubs(id);
    }

    @GetMapping("/{id}/my-history")
    ResponseEntity<List<HistoryResponse>> getCBidHistory(@PathVariable("id") String id){
        return getSBidHistory(id);
    }

    @GetMapping("/{id}/my-payment")
    ResponseEntity<List<TransactionResponse>> getCBidPayments(@PathVariable("id") String id){
        return getSBidPayments(id);
    }

    @PostMapping("/")
    ResponseEntity<BidResponse> setCBidDetails(@RequestBody BidRequest bidRequest){
        return setSBidDetails(bidRequest);
    }

}
