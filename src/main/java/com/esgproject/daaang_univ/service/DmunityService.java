package com.esgproject.daaang_univ.service;

import com.esgproject.daaang_univ.dto.DmunityDTO;
import com.esgproject.daaang_univ.dto.DstaDTO;

import java.util.List;

public interface DmunityService {
    DmunityDTO getDmunityById(Integer dmunityNo);
    List<DmunityDTO> getAllDmunities();
    // 필요에 따라 추가적인 메서드를 정의하세요.
}
