package com.taekyoungk.matching_service.domain.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taekyoungk.matching_service.domain.user.dto.UserDetailResponse;
import com.taekyoungk.matching_service.domain.user.dto.UserListResponse;
import com.taekyoungk.matching_service.domain.user.dto.UserSaveRequest;
import com.taekyoungk.matching_service.domain.user.dto.UserSearchParams;
import com.taekyoungk.matching_service.domain.user.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserSaveRequest request) {
        userService.create(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<UserListResponse> getUsers(UserSearchParams params) {
        return ResponseEntity.ok(userService.getUsers(params));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetailResponse> getUserById(@PathVariable String id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/{id}/views")
    public ResponseEntity<Void> incrementViews(@PathVariable String id) {
        userService.incrementViews(id);
        return ResponseEntity.ok().build();
    }
}
