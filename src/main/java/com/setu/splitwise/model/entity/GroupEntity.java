package com.setu.splitwise.model.entity;

import com.setu.splitwise.constants.Constants;
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
public class GroupEntity {
    @Id
    private String groupId;
    private String name;
    private String type;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdAt;
    private Date createdBy;

    @PostConstruct
    public void init() {
        this.groupId = Constants.PREFIX_GROUP + UUID.randomUUID();
    }
}
