package com.esgproject.daaang_univ.controller;

import com.esgproject.daaang_univ.dto.DstaDTO;
import com.esgproject.daaang_univ.service.DstaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

//    댕스타 작성 페이지
//    public dstaWrite(Integer dstaNo , String userid){
//        return dstaWrite;
//    }
}


