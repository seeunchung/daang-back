package com.esgproject.daaang_univ.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("admin".equals(username)) {
            // loginForm.getUsername()이 "admin"일 때만 하드코딩된 사용자 정보 반환
            return User.builder().username("admin").password("1234").roles("USER").build();
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
