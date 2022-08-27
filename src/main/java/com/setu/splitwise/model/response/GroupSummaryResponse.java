package com.setu.splitwise.model.response;

import com.setu.splitwise.model.UserBalance;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
public class GroupSummaryResponse {
    private List<UserBalance> userBalanceList;
}
