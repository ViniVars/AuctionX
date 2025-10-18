package com.example.ApiGateWay.Mapper;

import com.example.ApiGateWay.Dto.HistoryResponseDTO;
import types.AllHistoryResponse;
import types.HistoryResponse;

import java.util.ArrayList;
import java.util.List;

public class HistoryMapper {

    public static HistoryResponseDTO toDTO(HistoryResponse historyResponse){
        return new HistoryResponseDTO(historyResponse.getHistId(), LocalDateMapper.toLocalDateTime(historyResponse.getHistDate()), historyResponse.getBidId(), historyResponse.getProductName(), historyResponse.getBidCost(), historyResponse.getUserId(), historyResponse.getUserName(), historyResponse.getOwnerId(), historyResponse.getOwnerName());
    }

    public static List<HistoryResponseDTO> toDTOList(AllHistoryResponse allHistoryResponse){
        List<HistoryResponseDTO> myHist = new ArrayList<>();
        for(int i = 0; i < allHistoryResponse.getHistoryResponseCount(); i++){
            HistoryResponseDTO historyResponseDTO = toDTO(allHistoryResponse.getHistoryResponse(i));
            myHist.add(historyResponseDTO);
        }
        return myHist;
    }
}
