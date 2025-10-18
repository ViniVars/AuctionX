package com.example.Bid_MicroService.Mapper;

import com.example.Bid_MicroService.Entity.History;

import java.util.List;

public class HistoryMapper {


    public static bid_ms.HistoryResponse toProto(History history){
        return bid_ms.HistoryResponse.newBuilder()
                .setBidId(history.getBidId())
                .setOwnerId(history.getOwnerId())
                .setProductName(history.getProductName())
                .setOwnerName(history.getOwnerName())
                .setHistDate(LocalDateMapper.toTimeStamp(history.getHistDate()))
                .setHistId(history.getHistId())
                .setUserId(history.getUserId())
                .setUserName(history.getUserName())
                .build();
    }

    public static bid_ms.AllHistoryResponse toProtoList(List<History> allHistory){
        bid_ms.AllHistoryResponse.Builder allHistoryResponse = bid_ms.AllHistoryResponse.newBuilder();
        for (History history : allHistory) {
            bid_ms.HistoryResponse historyResponse = HistoryMapper.toProto(history);
            allHistoryResponse.addHistory(historyResponse);
        }
        return allHistoryResponse.build();
    }
}
