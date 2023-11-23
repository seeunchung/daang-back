package com.esgproject.daaang_univ.dao;
import com.esgproject.daaang_univ.dto.DoginfoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface DoginfoDAO {

    List<DoginfoDTO> doginfoList(Integer doginfoNo);

    void updateDoginfo(DoginfoDTO doginfoDTO);
}
