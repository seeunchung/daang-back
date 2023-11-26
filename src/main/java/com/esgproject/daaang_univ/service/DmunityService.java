package com.esgproject.daaang_univ.service;

import com.esgproject.daaang_univ.dto.DmunityDTO;
import com.esgproject.daaang_univ.dto.DstaDTO;

import java.util.List;

public interface DmunityService {
    DmunityDTO getDmunityById(Integer dmunityNo);
    List<DmunityDTO> getAllDmunities();
    void writeDmunity(DmunityDTO dmunityDTO);
    void editDmunity(Integer dmunityNo, DmunityDTO updatedPost);

    void deleteDmunity(Integer dmunityNo);

    Integer getTotalPageCount(Integer category);
}
