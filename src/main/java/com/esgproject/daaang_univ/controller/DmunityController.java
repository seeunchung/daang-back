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
@CrossOrigin("http://localhost:3000")
public class DmunityController {

    private final DmunityService service;

    @GetMapping("/dmunityMainPage")
    public ResponseEntity<List<DmunityDTO>> getAllDmunity() {
        List<DmunityDTO> allDmunities = service.getAllDmunities();
        return new ResponseEntity<>(allDmunities, HttpStatus.OK);
    }

    @GetMapping("/dmunityDetail/{dmunityNo}")
    public ResponseEntity<DmunityDTO> getDmunityById(@PathVariable Integer dmunityNo) {
        DmunityDTO dmunity = service.getDmunityById(dmunityNo);
        return ResponseEntity.ok(dmunity);
    }

    @PostMapping("/dmunityWrite")
    public void writeDmunity(@RequestBody DmunityDTO dmunityDTO) {
        service.writeDmunity(dmunityDTO);
    }
    @PutMapping("/dmunityEdit/{dmunityNo}")
    public void EditDmunity(
            @PathVariable Integer dmunityNo,
            @RequestBody DmunityDTO updatedPost
    ) {
        service.editDmunity(dmunityNo, updatedPost);
    }
    @DeleteMapping("/{dmunityNo}/dmunityDelete")
    public void deleteDmunity(@PathVariable Integer dmunityNo) {
        service.deleteDmunity(dmunityNo);
    }
    @GetMapping("/totalPageCount")
    public Integer getTotalPageCount(@RequestParam("category") Integer category) {
        return service.getTotalPageCount(category);
    }
}
