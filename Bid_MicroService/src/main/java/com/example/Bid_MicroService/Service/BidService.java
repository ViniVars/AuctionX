package com.example.Bid_MicroService.Service;

import bid_ms.*;
import bid_ms.AllBidResponse;
import bid_ms.BidByIdRequest;
import bid_ms.BidMsServiceGrpc.*;
import bid_ms.BidResponse;
import bid_ms.CreateBidRequest;
import com.example.Bid_MicroService.Entity.Bid;
import com.example.Bid_MicroService.Entity.History;
import com.example.Bid_MicroService.Mapper.BidMapper;
import com.example.Bid_MicroService.Mapper.HistoryMapper;
import com.example.Bid_MicroService.Repo.BidRepo;
import com.example.Bid_MicroService.Repo.HistoryRepo;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.Bid_MicroService.Mapper.BidMapper.toProtoList;


@Service
public class BidService extends BidMsServiceImplBase {

    @Autowired
    BidRepo bidRepo;

    @Autowired
    HistoryRepo historyRepo;



    @Override
    public void createBid(CreateBidRequest request, StreamObserver<BidResponse> responseObserver) {
        Bid bidRequest = BidMapper.toDto(request);
        Bid bidResponse = bidRepo.save(bidRequest);
        responseObserver.onNext(BidMapper.toProto(bidResponse));
        responseObserver.onCompleted();
    }

    @Override
    public void getBidDetails(BidByIdRequest request, StreamObserver<BidResponse> responseObserver) {
        Bid bid = bidRepo.bidFindById(request.getBidId());
        responseObserver.onNext(BidMapper.toProto(bid));
        responseObserver.onCompleted();
    }

    @Override
    public void getAllBidDetails(Empty request, StreamObserver<AllBidResponse> responseObserver) {
        List<Bid> allBids = bidRepo.findAll();
        responseObserver.onNext(BidMapper.toProtoList(allBids));
        responseObserver.onCompleted();
    }

    @Override
    public void getBidHistory(BidByIdRequest request, StreamObserver<bid_ms.AllHistoryResponse> responseObserver) {
        List<History> bidHistory = historyRepo.bidHistoryById(request.getBidId());
        responseObserver.onNext(HistoryMapper.toProtoList(bidHistory));
        responseObserver.onCompleted();
    }
}
