package com.setu.splitwise.model.entity;

import com.setu.splitwise.model.UserBalance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
//@Table(
//        uniqueConstraints = @UniqueConstraint(columnNames = {"transactionId", "userId"}),
//        indexes = @Index(columnList = {"groupId", "userId"})
//)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedNativeQuery(
        name = "get_user_balance_list",
        query = "SELECT USER_ID as userId, sum(BALANCE) as balance FROM EXPENSE_ENTITY WHERE GROUP_ID like ?1 group by USER_ID",
        resultSetMapping = "user_balance_list"
)
@SqlResultSetMapping(
        name = "user_balance_list",
        classes = @ConstructorResult(
                targetClass = UserBalance.class,
                columns = {
                        @ColumnResult(name = "userId", type = String.class),
                        @ColumnResult(name = "balance", type = Long.class)
                }
        )
)
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
