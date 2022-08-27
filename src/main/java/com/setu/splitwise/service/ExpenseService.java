package com.setu.splitwise.service;

import com.setu.splitwise.model.request.CreateExpenseRequest;
import org.springframework.stereotype.Service;

@Service
public interface ExpenseService {
    boolean addExpense(CreateExpenseRequest createExpenseRequest);

    Object getGroupExpenseSummery(String groupId);

    Object getGroupUserExpenseSummery(String groupId, String userId);

    Object getUserExpenseSummery(String userId);
}
