package com.taekyoungk.matching_service.domain.user.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"user\"")
public class User {
    @Id @Column(nullable = false, length = 30)
    private String id;
    @Column(nullable = false, length = 30)
    private String password;
    @Column(nullable = false, length = 30)
    private String name;
    private int points = 0;
    private int views = 0;
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @PrePersist
    public void onPrePersist() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }
    public User() {
    }

    public User(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getViews() {
        return views;
    }

    public LocalDateTime getCreateAt() {
        return createdAt;
    }
    
    public void incrementViews(){
        this.views++;
    }

    public void chargePoint(int point){
        this.points += point;
    }
}
