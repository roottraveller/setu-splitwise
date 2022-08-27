package com.setu.splitwise.model.response;

import com.setu.splitwise.model.UserGroupBalance;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class GroupUserSummaryResponse extends UserGroupBalance {
}
