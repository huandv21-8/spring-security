package com.huandv.SpringSecurity.config;

import com.huandv.SpringSecurity.repository.UserRepository;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Project: SpringSecurity
 * @Date: 6/25/2024 1:34 PM
 * @Author: crist
 */

@Service
@AllArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private UserRepository userRepository;


    // tạo userDetail để chuyền cho authentication provider của framework để xác thực
    // nếu như tự tạo authentication provider của riêng thì sẽ ko cần phải tạo userDetail
    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String email = null;
        String password = null;
        List<GrantedAuthority> authorities = null;
        List<com.huandv.SpringSecurity.entity.User> users = userRepository.findByEmail(username);

        if (users.size() == 0) {
            throw new UsernameNotFoundException("username not found with email: " + username);
        } else {
            email = users.get(0).getEmail();
            password = users.get(0).getPwd();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(users.get(0).getRole()));
        }

        return new User(email, password, authorities);
    }
}