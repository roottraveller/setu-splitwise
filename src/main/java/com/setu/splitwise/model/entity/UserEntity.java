package com.setu.splitwise.model.entity;

import com.setu.splitwise.model.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    private String userId;
    private String name;
    private String email;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdTime;
    @Builder.Default
    private Currency default_currency = Currency.INR;

}
