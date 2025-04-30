package com.taekyoungk.matching_service.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taekyoungk.matching_service.domain.user.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
    
}
