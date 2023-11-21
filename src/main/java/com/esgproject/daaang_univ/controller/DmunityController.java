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

    private final DmunityService dmunityService;
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/all")
    public ResponseEntity<List<DmunityDTO>> getAllDmunity() {
        List<DmunityDTO> allDmunities = dmunityService.getAllDmunities();
        return new ResponseEntity<>(allDmunities, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{dmunityNo}")
    public ResponseEntity<DmunityDTO> getDmunityById(@PathVariable Integer dmunityNo) {
        DmunityDTO dmunity = dmunityService.getDmunityById(dmunityNo);
        return ResponseEntity.ok(dmunity);
    }
}
