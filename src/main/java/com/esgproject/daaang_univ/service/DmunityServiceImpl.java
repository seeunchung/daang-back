package com.esgproject.daaang_univ.service;

import com.esgproject.daaang_univ.dao.DmunityDAO;
import com.esgproject.daaang_univ.dto.DmunityDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Primary
@Service
public class DmunityServiceImpl implements DmunityService {

    private final DmunityDAO dmunityDAO;

    @Override
    public DmunityDTO getDmunityById(Integer dmunityNo) {
        return dmunityDAO.findById(dmunityNo);
    }

    @Override
    public List<DmunityDTO> getAllDmunities() {
        return dmunityDAO.findAll();
    }
    // 필요에 따라 추가적인 서비스 메서드를 구현하세요.
}

