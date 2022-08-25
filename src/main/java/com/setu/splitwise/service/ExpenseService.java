package com.setu.splitwise.service;

import com.setu.splitwise.model.request.CreateExpenseRequest;
import org.springframework.stereotype.Service;

@Service
public interface ExpenseService {
    boolean addExpense(CreateExpenseRequest createExpenseRequest);
}
