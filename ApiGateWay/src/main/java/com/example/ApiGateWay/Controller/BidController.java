package com.example.ApiGateWay.Controller;


//import com.example.ApiGateWay.Dto.*;
//import org.springframework.data.repository.query.Param;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bids")
public class BidController {
//
//    @GetMapping("/")
//    ResponseEntity<List<BidResponse>> getCAllBids(
//            @RequestParam(defaultValue = "0") int skip,
//            @RequestParam(defaultValue = "20") int limit){
//        return ResponseEntity.ok(getSAllBids(skip, limit));
//    }
//
//    @GetMapping("/{id}")
//    ResponseEntity<BidResponse> getCBidDetails(@PathVariable("id") String id){
//        return ResponseEntity.ok(getSBidDetails(id));
//    }
//
//    @GetMapping("/{id}/my-history")
//    ResponseEntity<List<HistoryResponse>> getCBidHistory(
//            @PathVariable String id,
//            @RequestParam(defaultValue = "0") int skip,
//            @RequestParam(defaultValue = "20") int limit){
//        return ResponseEntity.ok(getSBidHistory(id, skip, limit));
//    }
//
//    @PostMapping("/")
//    ResponseEntity<BidResponse> setCBidDetails(@RequestBody BidRequest bidRequest){
//        return setSBidDetails(bidRequest);
//    }
//
}
