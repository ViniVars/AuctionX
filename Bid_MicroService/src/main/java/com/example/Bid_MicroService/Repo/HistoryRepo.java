package com.example.Bid_MicroService.Repo;

import com.example.Bid_MicroService.Entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HistoryRepo extends JpaRepository<History, Integer> {

    @Query(value = "SELECT * FROM history WHERE bid_id = :bidId", nativeQuery = true)
    List<History> bidHistoryById(@Param("bidId") int bidId);
}
