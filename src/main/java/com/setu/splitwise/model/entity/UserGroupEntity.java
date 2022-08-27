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
//@Table(
// uniqueConstraints = {@UniqueConstraint(columnNames = {"USER_ID", "GROUP_ID"})},
//   indexes = {@Index(columnList = {"USER_ID", "GROUP_ID"})})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@NamedNativeQuery(name = "find_user_groups", query = "select groupId from UserGroupEntity where ")
public class UserGroupEntity {
    @Id
    @GeneratedValue
    private long id;
    private String userId;
    private String groupId;
    @CreationTimestamp
    private Date createdTime;
}
