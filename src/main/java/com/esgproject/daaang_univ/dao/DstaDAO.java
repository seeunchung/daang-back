package com.esgproject.daaang_univ.dao;

import com.esgproject.daaang_univ.dto.DstaDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface DstaDAO {
    List<DstaDTO> dstaList(Integer dstar_no);
}
