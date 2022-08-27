package com.setu.splitwise.repository.h2;

import com.setu.splitwise.model.entity.ExpenseEntity;
import com.setu.splitwise.model.response.GroupSummaryResponse;
import com.setu.splitwise.model.response.GroupUserSummaryResponse;
import com.setu.splitwise.model.response.UserSummaryResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends CrudRepository<ExpenseEntity, String> {

    @Query(value = "SELECT userId, sum(balance) FROM ExpenseEntity WHERE groupId=?1 group by userId order by createdTime", nativeQuery = true)
    GroupSummaryResponse getUserBalanceList(String groupId);

    @Query(value = "SELECT userId, sum(balance) FROM ExpenseEntity WHERE userId=?1 and groupId=?2", nativeQuery = true)
    GroupUserSummaryResponse getUserBalance(String groupId, String userId);

    @Query(value = "SELECT userId, sum(balance), groupId FROM ExpenseEntity WHERE userId=?1 group by groupId order by createdTime", nativeQuery = true)
    UserSummaryResponse getUserBalance(String userId);

}
