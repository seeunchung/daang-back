package com.esgproject.daaang_univ.service;

import com.esgproject.daaang_univ.dao.MemberDAO;
import com.esgproject.daaang_univ.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Primary
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberDAO dao;

    @Override
    public void insertMember(MemberDTO memberDTO) {
        dao.insertMember(memberDTO);
    }

}

