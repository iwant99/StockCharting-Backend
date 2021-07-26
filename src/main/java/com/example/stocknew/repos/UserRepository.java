package com.example.stocknew.repos;

import com.example.stocknew.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUserName(String userName);

    Optional<User> existsByUserName(String userName);

    Optional<User> existsByEmailId(String emailId);

    Optional<User> existsByMobile(String mobile);
}