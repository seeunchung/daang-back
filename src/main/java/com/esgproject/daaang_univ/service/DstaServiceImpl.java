package com.esgproject.daaang_univ.service;

import com.esgproject.daaang_univ.dao.DstaDAO;
import com.esgproject.daaang_univ.dto.DstaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
public class DstaServiceImpl implements DstaService {

    private final DstaDAO dao;

    // 썸네일 파일을 서버에 저장하고, 파일 경로를 DstaDTO에 설정하는 메서드
    private String saveThumbnail(MultipartFile thumbnailFile) throws Exception {
        String uploadDir = "src/main/resources/static/images"; // 실제 서버에 저장할 디렉토리 경로
        Path uploadPath = Path.of(uploadDir);

        // 디렉토리가 없다면 생성
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // 썸네일 파일의 이름을 유니크하게 생성
        String fileName = System.currentTimeMillis() + "_" + thumbnailFile.getOriginalFilename();

        // 파일 저장 경로 설정
        Path filePath = uploadPath.resolve(fileName);

        // 파일 복사
        Files.copy(thumbnailFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        // 파일 경로 반환
        return uploadDir + "/" + fileName;
    }

    @Override
    public List<DstaDTO> dstaList(Integer dstarNo) {
        return dao.dstaList(dstarNo);
    }

    @Override
    public void insertDsta(DstaDTO dstaDTO, MultipartFile thumbnailFile) {
        try {
            // 썸네일 파일을 서버에 저장하고 파일 경로 설정
            String thumbnailFilePath = saveThumbnail(thumbnailFile);
            dstaDTO.setDstarThumbnail(thumbnailFilePath);

            // 데이터베이스에 저장
            dao.insertDsta(dstaDTO);
        } catch (Exception e) {
            // 예외 처리 로직 추가
            e.printStackTrace();
        }
    }

    @Override
    public DstaDTO getDstaByDstarNo(int dstarNo) {
        return dao.getDstaByDstarNo(dstarNo);
    }

    @Override
    public void updateDsta(DstaDTO dstaDTO) {
        dao.updateDsta(dstaDTO);
    }
    @Override
    public void deleteDsta(int dstarNo) {
        dao.deleteDsta(dstarNo);
    }
}
