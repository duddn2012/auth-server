package com.example.demo.user.repository;

import com.example.demo.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmailAndServiceCodeAndDeletedYnFalse(String email, String serviceCode);
    boolean existsByEmailAndServiceCodeAndDeletedYnFalse(String email, String serviceCode);
    Optional<User> findByServiceUserIdAndServiceCodeAndDeletedYnFalse(UUID serviceUserId, String serviceCode);
} 