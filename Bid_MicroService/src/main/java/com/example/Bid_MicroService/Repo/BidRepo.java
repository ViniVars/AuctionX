package com.example.Bid_MicroService.Repo;

import com.example.Bid_MicroService.Entity.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BidRepo extends JpaRepository<Bid, Integer> {
    @Query(value = "SELECT * FROM bids WHERE bid_id = :bidId", nativeQuery = true)
    Bid bidFindById(@Param("bidId") int bidId);
}
