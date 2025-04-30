package com.taekyoungk.matching_service.domain.user.dto;

import java.time.LocalDateTime;

public class UserDetailResponse {
    private String id;
    private String name;
    private int views;
    private int point;
    private LocalDateTime createdAt;

    public UserDetailResponse(String id, String name, int views, int point, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.views = views;
        this.point = point;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getViews() {
        return views;
    }
    public void setViews(int views) {
        this.views = views;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public int getPoint() {
        return point;
    }
    public void setPoint(int point) {
        this.point = point;
    }
    
}
