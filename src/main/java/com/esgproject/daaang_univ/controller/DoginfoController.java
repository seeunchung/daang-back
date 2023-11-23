package com.esgproject.daaang_univ.controller;

import com.esgproject.daaang_univ.dto.DoginfoDTO;
import com.esgproject.daaang_univ.service.DoginfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mypage")
@CrossOrigin(origins = "http://localhost:3000")
public class DoginfoController {
    private final DoginfoService service;

    // 강아지 정보 조회 엔드포인트
    @GetMapping("/doginfo")
    public ResponseEntity<List<DoginfoDTO>> doginfoList(@RequestParam(required = false) Integer doginfoNo) {
        List<DoginfoDTO> doginfoList = service.doginfoList(doginfoNo);
        return new ResponseEntity<>(doginfoList, HttpStatus.OK);
    }
    // 강아지 정보 업데이트 엔드포인트
    @PutMapping("/doginfo/update")
    public ResponseEntity<Void> updateDoginfo(@RequestBody DoginfoDTO doginfoDTO) {
        service.updateDoginfo(doginfoDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
