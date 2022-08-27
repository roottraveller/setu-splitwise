package com.setu.splitwise.model.response;

import com.setu.splitwise.model.UserGroupBalance;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserSummaryResponse extends UserGroupBalance {
}
