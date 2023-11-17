package com.esgproject.daaang_univ.service;

import com.esgproject.daaang_univ.dto.DmunityDTO;
import com.esgproject.daaang_univ.dto.DstaDTO;

import java.util.List;

public interface DmunityService {
    List<DmunityDTO> dmunityList(Integer dmunityNo);
}
