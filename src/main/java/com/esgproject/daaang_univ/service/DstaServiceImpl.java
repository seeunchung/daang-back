package com.esgproject.daaang_univ.service;

import com.esgproject.daaang_univ.dao.DstaDAO;
import com.esgproject.daaang_univ.dto.DstaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
public class DstaServiceImpl implements DstaService {

    private final DstaDAO dao;

    @Override
    public List<DstaDTO> dstaList(Integer dstar_no) {
        return dao.dstaList(dstar_no);
    }
}
