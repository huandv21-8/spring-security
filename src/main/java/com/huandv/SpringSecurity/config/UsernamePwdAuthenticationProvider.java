package com.huandv.SpringSecurity.config;
import com.huandv.SpringSecurity.entity.User;
import com.huandv.SpringSecurity.repository.UserRepository;
import com.huandv.SpringSecurity.entity.Authorities;
import com.huandv.SpringSecurity.repository.AuthoritiesRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Project: SpringSecurity
 * @Date: 6/25/2024 1:37 PM
 * @Author: crist
 */
@Component
@AllArgsConstructor
public class UsernamePwdAuthenticationProvider implements AuthenticationProvider {

    private UserRepository userRepository;
    private AuthoritiesRepository authoritiesRepository;
    private PasswordEncoder passwordEncoder;


    // tự tạo authentication provider để xác thực mật khẩu của riêng mình,
    // không dùng authentication provider của framework là DaoAuthenticationProvider
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pass = authentication.getCredentials().toString();

        List<User> users = userRepository.findByEmail(username);

        if (users.size() > 0) {
            if (passwordEncoder.matches(pass, users.get(0).getPwd())) {
//                List<Authorities> authoritiesList = authoritiesRepository.findAllByUser_UserId(users.get(0).getUserId());
                return new UsernamePasswordAuthenticationToken(username, pass, getGrantedAuthority(users.get(0).getAuthorities()));
            } else {
                throw new BadCredentialsException("invalid password");
            }
        } else {
            throw new BadCredentialsException("No user registered with this details!");
        }
    }

    private List<GrantedAuthority> getGrantedAuthority(Set<Authorities> authorities) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authorities authoritiesList : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authoritiesList.getName()));
        }
        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
