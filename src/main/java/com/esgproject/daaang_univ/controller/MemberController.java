package com.esgproject.daaang_univ.controller;

import com.esgproject.daaang_univ.dto.MemberDTO;
import com.esgproject.daaang_univ.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/join")
public class MemberController {
    private final MemberService service;
    @PostMapping("/write")
    public void insertMember(@RequestBody MemberDTO memberDTO) {
        service.insertMember(memberDTO);
    }
}
