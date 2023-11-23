package com.esgproject.daaang_univ.service;

import com.esgproject.daaang_univ.dto.DoginfoDTO;

import java.util.List;

public interface DoginfoService {
    List<DoginfoDTO> doginfoList(Integer doginfoNo);
    void updateDoginfo(DoginfoDTO doginfoDTO);
}
