package com.esgproject.daaang_univ.service;

import com.esgproject.daaang_univ.dto.DstaDTO;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DstaService {
    List<DstaDTO> dstaList(Integer dstarNo);

    void insertDsta(DstaDTO dstaDTO, MultipartFile thumbnailFile);

    DstaDTO getDstaByDstarNo(int dstarNo);

    void updateDsta(DstaDTO dstaDTO);

    void deleteDsta(int dstarNo);

    // 이미지 파일을 로드하는 메서드
    Resource loadImageAsResourceInternal(String fileName);
}