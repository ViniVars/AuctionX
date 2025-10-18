package com.example.ApiGateWay.Mapper;

import bid_ms.AllBidResponse;
import bid_ms.BidResponse;
import com.example.ApiGateWay.Dto.BidRequestDTO;
import com.example.ApiGateWay.Dto.BidResponseDTO;
import com.example.Bid_MicroService.Entity.*;
import com.example.Bid_MicroService.Mapper.LocalDateMapper.*;

import java.util.List;

import static com.example.Bid_MicroService.Mapper.LocalDateMapper.toLocalDate;
import static com.example.Bid_MicroService.Mapper.LocalDateMapper.toTimeStamp;


public class BidMapper {

    public static BidResponseDTO toDTO(BidResponse bidResponse){
        return new BidResponseDTO(bidResponse.getBidId(), bidResponse.getProductName(), bidResponse.getOwnerId(), bidResponse.getDescp(), LocalDateMapper.toLocalDate(bidResponse.getStartDate()), LocalDateMapper.toLocalDate(bidResponse.getEndDate()), bidResponse.getBasePrice(), bidResponse.getFinalPrice());
    }
}
