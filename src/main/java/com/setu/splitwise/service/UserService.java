package com.setu.splitwise.service;


import com.setu.splitwise.model.entity.UserEntity;
import com.setu.splitwise.model.request.CreateUserRequest;
import org.springframework.data.util.Pair;

import java.util.List;

public interface UserService {
    UserEntity createUser(CreateUserRequest createUserRequest);

    UserEntity getUserInfo(String userId);

    List<Pair<String, String>> getUserGroups(String userId);

}
