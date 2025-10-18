package com.example.Bid_MicroService.Mapper;

import com.example.Bid_MicroService.Entity.*;
import com.example.Bid_MicroService.Mapper.LocalDateMapper.*;
import java.util.List;

import static com.example.Bid_MicroService.Mapper.LocalDateMapper.toLocalDate;
import static com.example.Bid_MicroService.Mapper.LocalDateMapper.toTimeStamp;


public class BidMapper {

    public static Bid toDto(bid_ms.CreateBidRequest createBidRequest){
        Bid bid =  new Bid();
        bid.setProductName(createBidRequest.getProductName());
        bid.setDescp(createBidRequest.getDescp());
        bid.setOwnerId(createBidRequest.getOwnerId());
        bid.setOwnerName(createBidRequest.getOwnerName());
        bid.setStartDate(toLocalDate(createBidRequest.getStartDate()));
        bid.setEndDate(toLocalDate(createBidRequest.getEndDate()));
        bid.setBasePrice(createBidRequest.getBasePrice());
        bid.setFinalPrice(createBidRequest.getBasePrice());
    }

    public static bid_ms.BidResponse toProto(Bid bidResponseDTO){
        return bid_ms.BidResponse.newBuilder()
                .setBidId(bidResponseDTO.getBidId())
                .setBasePrice(bidResponseDTO.getBasePrice())
                .setCreatedAt(toTimeStamp(bidResponseDTO.getCreatedAt()))
                .setOwnerId(bidResponseDTO.getOwnerId())
                .setOwnerName(bidResponseDTO.getOwnerName())
                .setProductName(bidResponseDTO.getProductName())
                .setDescp(bidResponseDTO.getDescp())
                .setEndDate(toTimeStamp(bidResponseDTO.getEndDate()))
                .setStartDate(toTimeStamp(bidResponseDTO.getStartDate()))
                .setFinalPrice(bidResponseDTO.getFinalPrice())
                .build();
    }
    
    public static bid_ms.AllBidResponse toProtoList(List<Bid> allBids){
        bid_ms.AllBidResponse.Builder allBidResponse = bid_ms.AllBidResponse.newBuilder();
        for (Bid bid : allBids) {
            bid_ms.BidResponse bidResponse = toProto(bid);
            allBidResponse.addBidResponse(bidResponse).build();
        }
        return allBidResponse.build();
    }
}
