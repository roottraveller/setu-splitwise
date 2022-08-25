package com.setu.splitwise.utils;

import com.setu.splitwise.model.request.CreateGroupRequest;
import org.springframework.stereotype.Component;

@Component
public class GroupUtils {

    public boolean validate(CreateGroupRequest createGroupRequest) {
        return createGroupRequest.getName() != null && createGroupRequest.getType() != null
                && createGroupRequest.getCreatedBy() != null;
    }

}
