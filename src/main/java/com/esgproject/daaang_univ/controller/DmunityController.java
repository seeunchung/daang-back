package com.esgproject.daaang_univ.controller;

import com.esgproject.daaang_univ.dto.DmunityDTO;
import com.esgproject.daaang_univ.service.DmunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dmunity")
public class DmunityController {

    private final DmunityService service;
    @CrossOrigin(origins = "*")
    @GetMapping("/dmunityMainPage")
    public ResponseEntity<List<DmunityDTO>> dmunityList(@RequestParam(required = false) Integer dmunityNo) {
        List<DmunityDTO> dmunityList = service.dmunityList(dmunityNo);
        return new ResponseEntity<>(dmunityList, HttpStatus.OK);
    }
}
