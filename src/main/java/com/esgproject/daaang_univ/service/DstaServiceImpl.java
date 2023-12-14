package com.esgproject.daaang_univ.service;

import com.esgproject.daaang_univ.dao.DstaDAO;
import com.esgproject.daaang_univ.dto.DstaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
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

        // 파일 이름 반환
        return fileName;
    }

    // 이미지 파일을 로드하는 메서드 추가
    @Override
    public Resource loadImageAsResourceInternal(String fileName)  {
        try {
            String uploadDir = "src/main/resources/static/images"; // 실제 서버에 저장한 디렉토리 경로
            Path filePath = Paths.get(uploadDir).resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                return resource;
            } else {
                throw new FileNotFoundException("File not found: " + fileName);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Malformed URL for file: " + fileName, e);
        } catch (Exception e) {
            throw new RuntimeException("Error loading file: " + fileName, e);
        }
    }
    // 썸네일 파일을 서버에서 삭제하는 메서드
    private void deleteThumbnail(String fileName) {
        try {
            String uploadDir = "src/main/resources/static/images"; // 실제 서버에 저장한 디렉토리 경로

            Path filePath = Paths.get(uploadDir).resolve(fileName).normalize();
            // 파일 삭제
            Files.deleteIfExists(filePath);

        } catch (Exception e) {
            // 예외 처리 로직 추가
            e.printStackTrace();
        }
    }

    @Override
    public List<DstaDTO> dstaList(Integer dstarNo) {
        return dao.dstaList(dstarNo);
    }

    @Override
    public void insertDsta(DstaDTO dstaDTO, MultipartFile thumbnailFile) {
        try {
            // 썸네일 파일을 서버에 저장하고 파일 이름 설정
            String fileName = saveThumbnail(thumbnailFile);
            dstaDTO.setDstarThumbnail(fileName); // 데이터베이스에는 파일 이름만 저장

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
            public void updateDsta(DstaDTO dstaDTO, MultipartFile thumbnailFile) {
        try {
            // 썸네일 파일이 변경되었을 때만 처리
            if (thumbnailFile != null && !thumbnailFile.isEmpty()) {
                // 기존 썸네일 파일 삭제
                DstaDTO existingDsta = dao.getDstaByDstarNo(dstaDTO.getDstarNo());
                deleteThumbnail(existingDsta.getDstarThumbnail());
                // 새로운 썸네일 파일 이름으로 설정
                String fileName = saveThumbnail(thumbnailFile);
                dstaDTO.setDstarThumbnail(fileName); // 데이터베이스에는 파일 이름만 저장
            } else {
                // thumbnailFile이 null이거나 비어있으면 기존 데이터베이스에 있는 값을 사용
                DstaDTO existingDsta = dao.getDstaByDstarNo(dstaDTO.getDstarNo());
                dstaDTO.setDstarThumbnail(existingDsta.getDstarThumbnail());
            }
            // 데이터베이스에 저장
            dao.updateDsta(dstaDTO);
        } catch (Exception e) {
            // 예외 처리 로직 추가
            e.printStackTrace();
        }
    }
    @Override
    public void deleteDsta(int dstarNo) {
        try {
            // 기존 DTO를 가져와서 썸네일 파일 이름을 얻기
            DstaDTO existingDsta = dao.getDstaByDstarNo(dstarNo);

            // 썸네일 파일을 삭제
            deleteThumbnail(existingDsta.getDstarThumbnail());

            // 데이터베이스에서 DTO를 삭제
            dao.deleteDsta(dstarNo);
        } catch (Exception e) {
            // 예외 처리 로직 추가
            e.printStackTrace();
        }
    }

}
