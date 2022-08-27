package com.setu.splitwise.controller;

import com.setu.splitwise.model.request.CreateExpenseRequest;
import com.setu.splitwise.service.ExpenseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping ("/summery/{groupId}")
    public ResponseEntity<Boolean> getGroupExpenseSummery(@PathVariable("groupId") String groupId) {
        //TODO
        return ResponseEntity.ok(expenseService.getGroupExpenseSummery(groupId));
    }

    @GetMapping("/summery/{groupId}/{userId}")
    public ResponseEntity<> getGroupUserExpenseSummery(@PathVariable("groupId") String groupId,
                                                       @PathVariable("userId") String userId) {
        return ResponseEntity.ok(expenseService.getGroupUserExpenseSummery(groupId, userId));
    }

    @GetMapping("/summery/{userId}")
    public ResponseEntity<> getUserExpenseSummery(@PathVariable("userId") String userId) {
        return ResponseEntity.ok(expenseService.getUserExpenseSummery(userId));
    }


    @GetMapping("/simplified")
    public ResponseEntity<Boolean> simplifiedExpense(){
        return ResponseEntity.ok(expenseService.simplifiedExpense());
    }

}
