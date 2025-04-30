package com.taekyoungk.matching_service.domain.user.dto;

import java.time.LocalDateTime;

public class UserDto {
    private String id;
    private String name;
    private int views;
    private LocalDateTime createdAt;

    public UserDto(String id, String name, int views, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.views = views;
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
}
