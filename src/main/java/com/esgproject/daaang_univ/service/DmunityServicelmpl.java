package com.esgproject.daaang_univ.service;

import com.esgproject.daaang_univ.dao.DmunityDAO;
import com.esgproject.daaang_univ.dto.DmunityDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
public class DmunityServicelmpl implements DmunityService {

    private final DmunityDAO dao;

    @Override
    public List<DmunityDTO> dmunityList(Integer dmunityNo) {
        return dao.dmunityList(dmunityNo);
    }
}

