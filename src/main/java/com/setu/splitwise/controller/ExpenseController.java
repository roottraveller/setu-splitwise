package com.setu.splitwise.controller;

import com.setu.splitwise.model.request.CreateExpenseRequest;
import com.setu.splitwise.service.ExpenseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/splitwise/expense")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/add")
    public ResponseEntity<Boolean> addExpense(@RequestBody CreateExpenseRequest createExpenseRequest) {
        return ResponseEntity.ok(expenseService.addExpense(createExpenseRequest));
    }

    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteExpense(@RequestBody long eidx) {
        //TODO
        return ResponseEntity.ok(Boolean.FALSE);
    }
}
