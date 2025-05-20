package com.example.demo.user.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "service_user")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @Column(name = "service_user_id")
    private UUID serviceUserId;

    @Column(name = "service_code", nullable = false)
    private String serviceCode;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String status;

    @Column(name = "logined_at")
    private LocalDateTime loginedAt;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_yn")
    private boolean deletedYn;

    @Builder
    public User(UUID serviceUserId, String serviceCode, String email, String password,
                String nickname, String status) {
        this.serviceUserId = serviceUserId;
        this.serviceCode = serviceCode;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.status = status;
        this.deletedYn = false;
    }

    public void updateLoginTime() {
        this.loginedAt = LocalDateTime.now();
    }

    public void updatePassword(String newPassword) {
        this.password = newPassword;
    }

    public void updateStatus(String status) {
        this.status = status;
    }

    public void delete() {
        this.deletedYn = true;
    }
} 