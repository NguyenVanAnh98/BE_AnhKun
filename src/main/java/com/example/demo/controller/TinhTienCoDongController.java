package com.example.demo.controller;

import com.example.demo.model.dto.ChungChi;
import com.example.demo.service.TinhTienCoDongService;
import com.example.demo.service.TinhTienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/tinhtiencodong")

public class TinhTienCoDongController {
    @Autowired
    private TinhTienCoDongService tinhTienCoDongService;
    @Autowired
    private TinhTienService tinhTienService;
    @GetMapping("{id}/cd")
    public ResponseEntity<?> findTopByCoDongId(@PathVariable Long id){
        return new ResponseEntity<>(tinhTienCoDongService.findTopByCoDongId(id), HttpStatus.OK);
    }
    @PutMapping("{id}/cd")
    public ResponseEntity<?> UpdateTinhTienCoDongId(@PathVariable Long id, @RequestBody ChungChi chungChi){
        tinhTienCoDongService.saveChungChiCoDong(chungChi, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
