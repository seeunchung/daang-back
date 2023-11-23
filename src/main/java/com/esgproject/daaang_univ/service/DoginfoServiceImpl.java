package com.esgproject.daaang_univ.service;

import com.esgproject.daaang_univ.dao.DoginfoDAO;
import com.esgproject.daaang_univ.dto.DoginfoDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Primary
public class DoginfoServiceImpl implements DoginfoService {
    private final DoginfoDAO dao;
    @Override
    public List<DoginfoDTO> doginfoList(Integer doginfoNo) {
        return dao.doginfoList(doginfoNo);
    }

    @Transactional
    @Override
    public void updateDoginfo(DoginfoDTO doginfoDTO) {
        dao.updateDoginfo(doginfoDTO);
    }
}
