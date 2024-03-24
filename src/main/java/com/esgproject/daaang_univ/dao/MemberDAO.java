package com.esgproject.daaang_univ.dao;

import com.esgproject.daaang_univ.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MemberDAO {
    // 댕스타 삽입 메서드 추가
    void insertMember(MemberDTO memberDTO);
}
