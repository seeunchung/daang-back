package com.esgproject.daaang_univ.dao;

import com.esgproject.daaang_univ.dto.DmunityDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface DmunityDAO {
    DmunityDTO findById(Integer dmunityNo);
    List<DmunityDTO> findAll();
    // 필요에 따라 추가적인 메서드를 정의하세요.
}
