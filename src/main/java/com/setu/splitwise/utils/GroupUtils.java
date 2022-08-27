package com.setu.splitwise.utils;

import com.setu.splitwise.constants.Constants;
import com.setu.splitwise.exception.GenericException;
import com.setu.splitwise.model.request.CreateGroupRequest;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;

import java.util.Map;
import java.util.UUID;

@UtilityClass
public class GroupUtils {

    public static void validate(CreateGroupRequest createGroupRequest) {
        if (createGroupRequest.getName() != null &&
                createGroupRequest.getType() != null &&
                createGroupRequest.getCreatedBy() != null) {
            throw GenericException.builder()
                    .httpCode(HttpStatus.BAD_REQUEST.value())
                    .httpStatus(HttpStatus.BAD_REQUEST.getReasonPhrase())
                    .context(Map.of("reason", "empty field value"))
                    .build();
        }
    }

    public static String generateGroupId() {
        return Constants.PREFIX_GROUP + UUID.randomUUID();
    }

}
