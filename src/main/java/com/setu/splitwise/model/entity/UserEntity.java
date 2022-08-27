package com.setu.splitwise.model.entity;

import com.setu.splitwise.constants.Constants;
import com.setu.splitwise.model.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

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
    private Date createdAt;
    private Currency default_currency;

    @PostConstruct
    public void init() {
        this.userId = Constants.PREFIX_USER + UUID.randomUUID();
        this.default_currency = Currency.INR;
    }
}
