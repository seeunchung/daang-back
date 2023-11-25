package com.esgproject.daaang_univ.service;

import com.esgproject.daaang_univ.dto.DstaDTO;

import java.util.List;

public interface DstaService {
    List<DstaDTO> dstaList(Integer dstarNo);

    void insertDsta(DstaDTO dstaDTO);

    DstaDTO getDstaByDstarNo(int dstarNo);

    void updateDsta(DstaDTO dstaDTO);

    void deleteDsta(int dstarNo);
}