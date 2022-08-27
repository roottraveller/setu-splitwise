package com.setu.splitwise.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expanse {
    private String userId;
    private long paidAmount;
//    private long ownAmount;
}
