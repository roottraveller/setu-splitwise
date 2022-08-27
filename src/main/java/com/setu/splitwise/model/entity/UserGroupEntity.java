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
//@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"userId", "groupId"})},
//        indexes = {@Index(columnList = {"userId", "groupId"})})
@AllArgsConstructor
@NoArgsConstructor
//@NamedNativeQuery(name = "find_user_groups", query = "select groupId from UserGroupEntity where ")
public class UserGroupEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String userId;
    private String groupId;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdTime;
}
