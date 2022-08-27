package com.setu.splitwise.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
//@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"transactionId", "userId"}),
//        indexes = @Index(columnList = {"groupId", "userId"}))
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseEntity {
    @Id
    @GeneratedValue
    private long id;
    private String transactionId;
    private String userId;
    private long paidAmount;
    private long balance;
    private String groupId;
    @CreationTimestamp
    private Date createdTime;

}
