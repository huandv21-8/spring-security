package com.huandv.SpringSecurity.repository;

import com.huandv.SpringSecurity.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @Project: SpringSecurity
 * @Date: 6/25/2024 1:46 PM
 * @Author: crist
 */
@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    List<User> findByEmail(String username);
}
