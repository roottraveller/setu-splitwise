package com.setu.splitwise.service.impl;

import com.setu.splitwise.handler.ExpenseHandler;
import com.setu.splitwise.model.request.CreateExpenseRequest;
import com.setu.splitwise.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    @Autowired
    private ExpenseHandler expenseHandler;

    @Override
    public boolean addExpense(CreateExpenseRequest createExpenseRequest) {
        return expenseHandler.addExpense(createExpenseRequest);
    }

    @Override
    public Object getGroupExpenseSummery(String groupId) {
        return expenseHandler.getGroupExpenseSummery(groupId);
    }

    @Override
    public Object getGroupUserExpenseSummery(String groupId, String userId) {
        return null;
    }

    @Override
    public Object getUserExpenseSummery(String userId) {
        return null;
    }
}
