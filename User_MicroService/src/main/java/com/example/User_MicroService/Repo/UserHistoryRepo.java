package com.example.User_MicroService.Repo;

import com.example.User_MicroService.Entity.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserHistoryRepo extends JpaRepository<UserHistory, Integer> {

    @Query(value = "SELECT * FROM UserProjectionHistory WHERE user_id = :userId", nativeQuery = true)
    List<UserHistory> findAllHistoryById(@Param("userId") int userId);
}
