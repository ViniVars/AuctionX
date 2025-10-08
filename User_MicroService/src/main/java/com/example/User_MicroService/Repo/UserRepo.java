package com.example.User_MicroService.Repo;


import com.example.User_MicroService.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import user_ms.UserResponse;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    @Query(value = "SELECT user_name FROM users WHERE user_name = :userName AND password = :password", nativeQuery = true)
    UserResponse userLogin(@Param("userName") String userName, @Param("password") String password);
}
