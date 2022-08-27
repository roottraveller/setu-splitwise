package com.setu.splitwise.model.entity;

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
public class GroupEntity {
    @Id
    private String groupId;
    private String name;
    private String type;
    private String createdBy;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdTime;

}
