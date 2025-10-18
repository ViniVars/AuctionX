package com.example.ApiGateWay.Service;


import bid_ms.AllBidResponse;
import bid_ms.BidMsServiceGrpc;
import com.example.ApiGateWay.Dto.BidRequestDTO;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidService {

    private BidMsServiceGrpc.BidMsServiceBlockingStub bidMsServiceBlockingStub;


    private synchronized void initStub(){
        if(bidMsServiceBlockingStub == null){
            ManagedChannel channel = ManagedChannelBuilder
                    .forAddress("bid-ms", 9090)
                    .usePlaintext()
                    .build();
            bidMsServiceBlockingStub = BidMsServiceGrpc.newBlockingStub(channel);
        }
    }

    public List<BidRequestDTO> getSAllBids(){
        AllBidResponse allBidResponse = bidMsServiceBlockingStub.getAllBidDetails(Empty.getDefaultInstance());
        List<BidRequestDTO> allBidRequestDTO =
    }

}
