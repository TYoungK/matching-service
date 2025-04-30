package com.taekyoungk.matching_service.domain.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taekyoungk.matching_service.common.exception.user.UserNotFoundException;
import com.taekyoungk.matching_service.domain.user.dto.UserDetailResponse;
import com.taekyoungk.matching_service.domain.user.dto.UserDto;
import com.taekyoungk.matching_service.domain.user.dto.UserListResponse;
import com.taekyoungk.matching_service.domain.user.dto.UserSaveRequest;
import com.taekyoungk.matching_service.domain.user.dto.UserSearchParams;
import com.taekyoungk.matching_service.domain.user.entity.User;
import com.taekyoungk.matching_service.domain.user.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void create(UserSaveRequest userSaveRequest){
        User user = new User(userSaveRequest.getId(), userSaveRequest.getPassword(), userSaveRequest.getName());
        userRepository.save(user);
    }
    @Transactional
    public UserListResponse getUsers(UserSearchParams params){
        Sort sort = Sort.by(Sort.Direction.fromString(params.getSortDir().toString()), params.getSortBy());
        Pageable pageable = PageRequest.of(params.getPage(), params.getSize(), sort);
        Page<User> page = userRepository.findAll(pageable);
        List<UserDto> userDtos = page.getContent().stream().map(user -> new UserDto(user.getId(), user.getName(), user.getViews(), user.getCreateAt())).toList();
        return new UserListResponse(
            userDtos,
            page.getTotalElements(),
            page.getTotalPages()
        );
    }

    @Transactional
    public UserDetailResponse getUserById(String id){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return new UserDetailResponse(id, user.getName(), user.getViews(), user.getPoints(), user.getCreateAt());
    }

    @Transactional
    public void incrementViews(String id){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        user.incrementViews();
    }

    @Transactional
    public void chargePoint(String id, int point){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        user.chargePoint(point);
    }
}
