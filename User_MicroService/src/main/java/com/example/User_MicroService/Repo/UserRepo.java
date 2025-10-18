package com.example.User_MicroService.Repo;


import com.example.User_MicroService.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM users WHERE user_name = :userName AND password = :password", nativeQuery = true)
    User userLogin(@Param("userName") String userName, @Param("password") String password);
}
