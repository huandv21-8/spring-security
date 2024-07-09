package com.huandv.SpringSecurity.repository;

import com.huandv.SpringSecurity.entity.Authorities;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @Project: SpringSecurity
 * @Date: 6/25/2024 2:08 PM
 * @Author: crist
 */
@Repository
public interface AuthoritiesRepository extends CrudRepository<Authorities, Integer> {
    List<Authorities> findAllByUser_UserId(int userId);
}
