package com.taekyoungk.matching_service.domain.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import com.taekyoungk.matching_service.common.enums.SortDirection;
import com.taekyoungk.matching_service.domain.user.dto.UserDetailResponse;
import com.taekyoungk.matching_service.domain.user.dto.UserListResponse;
import com.taekyoungk.matching_service.domain.user.dto.UserSaveRequest;
import com.taekyoungk.matching_service.domain.user.dto.UserSearchParams;
import com.taekyoungk.matching_service.domain.user.service.UserService;

@ActiveProfiles("test")
@SpringBootTest
@Transactional
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void createTest(){
        String id = "test9999";
        userService.create(new UserSaveRequest(id, "테스트9999", "1111"));
        UserDetailResponse userDto = userService.getUserById(id);
        assertEquals(userDto.getName(), "테스트9999");
        // UserListResponse userListResponse = userService.getUsers(new UserSearchParams());
        // userListResponse.getUsers().size()
    }

    @Test
    void searchTest(){
        for (int i = 0; i < 100; i++) {
            userService.create(new UserSaveRequest(String.format("test%d", i), String.format("테스트%d", i), "1111"));
        }
        UserSearchParams userSearchParams = new UserSearchParams();
        UserListResponse userListResponse = userService.getUsers(userSearchParams);
        assertEquals(userListResponse.getUsers().size(), userSearchParams.getSize());
        userSearchParams.setPage(8);
        userListResponse = userService.getUsers(userSearchParams);
        assertEquals(userListResponse.getUsers().get(0).getName(), "테스트19");
    }

    @Test
    void increamentViewsTest(){
        String id = "test9999";
        userService.create(new UserSaveRequest(id, "테스트9999", "1111"));
        userService.incrementViews(id);
        UserDetailResponse userDto = userService.getUserById(id);
        assertEquals(userDto.getViews(), 1);
    }
}
