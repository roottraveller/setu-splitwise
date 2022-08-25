package com.setu.splitwise.utils;

import com.setu.splitwise.model.request.CreateUserRequest;
import org.springframework.stereotype.Component;

@Component
public class UserUtils {

    /**
     * @return no user info will less than 5 length allow
     */
    public boolean validate(CreateUserRequest createUserRequest) {
        return createUserRequest.getName() != null && createUserRequest.getName().length() > 5
                && createUserRequest.getEmail() != null && createUserRequest.getEmail().length() > 5;
    }
}
