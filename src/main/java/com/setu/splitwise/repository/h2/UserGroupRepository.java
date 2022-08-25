package com.setu.splitwise.repository.h2;

import com.setu.splitwise.model.entity.UserGroupEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserGroupRepository extends CrudRepository<UserGroupEntity, String> {

    //    @Query(nativeQuery = true, name = "find_user_groups")
    @Query(value = "SELECT userId FROM UserGroupEntity user WHERE userId = ?1", nativeQuery = true)
    List<Pair<String, String>> getUserGroupList(String userId);
    //TODO
}
