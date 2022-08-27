package com.setu.splitwise.repository.h2;

import com.setu.splitwise.model.UserBalance;
import com.setu.splitwise.model.entity.ExpenseEntity;
import com.setu.splitwise.model.response.GroupSummaryResponse;
import com.setu.splitwise.model.response.GroupUserSummaryResponse;
import com.setu.splitwise.model.response.UserSummaryResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends CrudRepository<ExpenseEntity, String> {

    //SELECT USER_ID as userId, sum(BALANCE) as balance FROM EXPENSE_ENTITY WHERE GROUP_ID like 'g_4b26b262-11ec-40da-aa30-e7b4e2afb78e'  group by USER_ID
    @Query(nativeQuery = true, name = "get_user_balance_list")
    List<UserBalance> getUserBalanceList(String groupId);

    @Query(value = "SELECT userId, sum(balance) FROM ExpenseEntity WHERE userId=?1 and groupId=?2", nativeQuery = true)
    GroupUserSummaryResponse getUserBalance(String groupId, String userId);

    @Query(value = "SELECT userId, sum(balance), groupId FROM ExpenseEntity WHERE userId=?1 group by groupId order by createdTime", nativeQuery = true)
    UserSummaryResponse getUserBalance(String userId);

}
