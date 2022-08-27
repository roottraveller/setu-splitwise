package com.setu.splitwise.handler;

import com.setu.splitwise.model.Expanse;
import com.setu.splitwise.model.entity.ExpenseEntity;
import com.setu.splitwise.model.entity.TransactionEntity;
import com.setu.splitwise.model.request.CreateExpenseRequest;
import com.setu.splitwise.model.response.GroupSummaryResponse;
import com.setu.splitwise.model.response.GroupUserSummaryResponse;
import com.setu.splitwise.model.response.UserSummaryResponse;
import com.setu.splitwise.repository.h2.ExpenseRepository;
import com.setu.splitwise.repository.h2.TransactionRepository;
import com.setu.splitwise.utils.ExpenseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExpenseHandler {
    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    // TODO - enable transaction support
    public boolean addExpense(CreateExpenseRequest createExpenseRequest) {
        String uniqueTransactionId = ExpenseUtils.generateTransactionId();

        long totalAmount = createExpenseRequest.getExpanses().stream().mapToLong(Expanse::getPaidAmount).sum();
        long totalUsers = createExpenseRequest.getExpanses().size();
        long perUserShare = totalAmount / totalUsers;
        for (Expanse expanse : createExpenseRequest.getExpanses()) {
            expenseRepository.save(ExpenseEntity.builder()
                    .transactionId(uniqueTransactionId)
                    .userId(expanse.getUserId())
                    .paidAmount(expanse.getPaidAmount())
                    .balance(perUserShare - expanse.getPaidAmount())
                    .groupId(createExpenseRequest.getGroupId())
                    .build());
        }
        transactionRepository.save(TransactionEntity.builder()
                .transactionId(uniqueTransactionId)
                .description(createExpenseRequest.getDescription())
                .build());
        return true;
    }

    public GroupSummaryResponse getGroupSummary(String groupId) {
        return expenseRepository.getUserBalanceList(groupId);
    }

    public UserSummaryResponse getUserSummary(String userId) {
        return expenseRepository.getUserBalance(userId);
    }

    public GroupUserSummaryResponse getGroupUserSummary(String groupId, String userId) {
        return expenseRepository.getUserBalance(groupId, userId);
    }
}
