package com.taekyoungk.matching_service.domain.user.dto;

import java.util.List;

public class UserListResponse {
    private List<UserDto> users;
    private long totalElements;
    private int totalPages;

    public UserListResponse(List<UserDto> users, long totalElements, int totalPages) {
        this.users = users;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }
    public List<UserDto> getUsers() {
        return users;
    }
    public long getTotalElements() {
        return totalElements;
    }
    public int getTotalPages() {
        return totalPages;
    }
}
