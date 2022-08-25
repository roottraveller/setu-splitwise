package com.setu.splitwise.controller;


import com.setu.splitwise.Utils.UserUtils;
import com.setu.splitwise.model.entity.UserEntity;
import com.setu.splitwise.model.request.CreateUserRequest;
import com.setu.splitwise.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/splitwise/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserUtils userUtils;

    @PostMapping("/add")
    public ResponseEntity<UserEntity> createUser(@RequestBody CreateUserRequest createUserRequest) {
        if (!userUtils.validate(createUserRequest)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userService.createUser(createUserRequest));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserEntity> getUserInfo(@PathVariable("userId") String userId) {
        return ResponseEntity.ok(userService.getUserInfo(userId));
    }

    @GetMapping("/{userId}/groups")
    public ResponseEntity<List<Pair<String, String>>> getUserGroups(@PathVariable("userId") String userId) {
        return ResponseEntity.ok(userService.getUserGroups(userId));
    }
}
