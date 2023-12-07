package com.esgproject.daaang_univ.controller;

import com.esgproject.daaang_univ.dto.DstaDTO;
import com.esgproject.daaang_univ.service.DstaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dsta")
public class DstaController {

    private final DstaService service;

// 댕스타 메인 페이지 리스트
    @GetMapping("/dstaMainPage")
    public ResponseEntity<List<DstaDTO>> dstaList(@RequestParam(required = false) Integer dstarNo) {
        List<DstaDTO> dstaList = service.dstaList(dstarNo);
        return new ResponseEntity<>(dstaList, HttpStatus.OK);
    }
    // dstarNo로 선택 작업을 위한 코드 추가
    @GetMapping("/getDstaByDstarNo/{dstarNo}")
    public ResponseEntity<DstaDTO> getDstaByDstarNo(@PathVariable int dstarNo) {
        DstaDTO dstaDTO = service.getDstaByDstarNo(dstarNo);
        return new ResponseEntity<>(dstaDTO, HttpStatus.OK);
    }

    // 댕스타 작성 페이지 - 댕스타 삽입을 위한 코드 추가
    @PostMapping("/dstaWrite")
    public ResponseEntity<Void> dstaWrite(@ModelAttribute DstaDTO dstaDTO, @RequestParam("thumbnailFile") MultipartFile thumbnailFile) {
        service.insertDsta(dstaDTO, thumbnailFile);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // 댕스타 수정을 위한 코드 추가
    @PutMapping("/dstarEdit")
    public ResponseEntity<Void> updateDsta(@RequestBody DstaDTO dstaDTO) {
        service.updateDsta(dstaDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 댕스타 삭제를 위한 코드 추가
    @DeleteMapping("/deleteDsta/{dstarNo}")
    public ResponseEntity<Void> deleteDsta(@PathVariable int dstarNo) {
        service.deleteDsta(dstarNo);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


