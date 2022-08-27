package com.setu.splitwise.controller;

import com.setu.splitwise.model.request.CreateExpenseRequest;
import com.setu.splitwise.model.response.GroupSummaryResponse;
import com.setu.splitwise.model.response.GroupUserSummaryResponse;
import com.setu.splitwise.model.response.UserSummaryResponse;
import com.setu.splitwise.service.ExpenseService;
import com.setu.splitwise.utils.ExpenseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.OperationNotSupportedException;

@Slf4j
@RestController
@RequestMapping("/api/splitwise/expense")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/add")
    public ResponseEntity<Boolean> addExpense(@RequestBody CreateExpenseRequest createExpenseRequest) {
        ExpenseUtils.validate(createExpenseRequest);
        return ResponseEntity.ok(expenseService.addExpense(createExpenseRequest));
    }

    @GetMapping("/summary/group/{groupId}")
    public ResponseEntity<GroupSummaryResponse> getGroupSummary(@PathVariable("groupId") String groupId) {
        return ResponseEntity.ok(expenseService.getGroupSummary(groupId));
    }

    @GetMapping("/summary/group/{groupId}/{userId}")
    public ResponseEntity<GroupUserSummaryResponse> getGroupUserSummary(@PathVariable("groupId") String groupId,
                                                                        @PathVariable("userId") String userId) {
        return ResponseEntity.ok(expenseService.getGroupUserSummary(groupId, userId));
    }

    @GetMapping("/summary/user/{userId}")
    public ResponseEntity<UserSummaryResponse> getUserSummary(@PathVariable("userId") String userId) {
        return ResponseEntity.ok(expenseService.getUserSummary(userId));
    }


    @GetMapping("/simplified")
    public ResponseEntity<Object> simplifiedExpense() throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

}
