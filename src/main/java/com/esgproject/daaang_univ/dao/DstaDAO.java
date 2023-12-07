package com.esgproject.daaang_univ.dao;

import com.esgproject.daaang_univ.dto.DstaDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Repository
@Mapper
public interface DstaDAO {
    List<DstaDTO> dstaList(Integer dstarNo);
    // 댕스타 삽입 메서드 추가
    void insertDsta(DstaDTO dstaDTO);
    // dstarNo로 선택 작업 메서드 추가
    DstaDTO getDstaByDstarNo(int dstarNo);

    // 댕스타 수정 메서드 추가
    void updateDsta(DstaDTO dstaDTO);

    // 댕스타 삭제 메서드
    void deleteDsta(int dstarNo);
}
