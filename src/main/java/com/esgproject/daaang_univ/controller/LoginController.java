package com.esgproject.daaang_univ.controller;

import jakarta.servlet.http.HttpSession;
import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import com.esgproject.daaang_univ.service.UserService;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/user")
    @ResponseBody
    public String login(@RequestBody LoginForm loginForm, HttpSession session) {

        UserDetails userDetails = userService.loadUserByUsername(loginForm.getUsername());

        if (userDetails.getPassword().equals(loginForm.getPassword())) {
            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

            // SecurityContext에 인증 정보 설정
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // 세션에 SecurityContext 저장
            session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                    SecurityContextHolder.getContext());

            return "Login successful!";
        } else {
            return "Invalid credentials!";
        }
    }

    // 로그인 폼에서 전달되는 데이터를 받기 위한 클래스
    @Data
    private static class LoginForm {
        private String username;
        private String password;
    }

    @PostMapping("/logout")
    @ResponseBody
    public String logout(HttpSession session) {
        // 세션에서 SecurityContext 제거
        session.removeAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);

        // SecurityContext를 클리어하여 로그아웃 상태로 만듦
        SecurityContextHolder.clearContext();

        return "Logout successful";
    }
}
