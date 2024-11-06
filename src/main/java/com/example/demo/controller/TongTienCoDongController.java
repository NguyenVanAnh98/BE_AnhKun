package com.example.demo.controller;

import com.example.demo.model.dto.ChungChi;
import com.example.demo.service.TinhTienCoDongService;
import com.example.demo.service.TinhTienService;
import com.example.demo.service.TongTienCoDongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tongtiencodong")
public class TongTienCoDongController {
    @Autowired
    private TongTienCoDongService tongTienCoDongService;
    @Autowired
    private TinhTienService tinhTienService;
    @Autowired
    private TinhTienCoDongService tinhTienCoDongService;
    @GetMapping("{id}/tcd")
    public ResponseEntity<?> findTopByCoDongId(@PathVariable Long id) {
        return new ResponseEntity<>(tongTienCoDongService.findTopByCoDongId(id), HttpStatus.OK);
    }
    @GetMapping("{id}/{startDate}")
    public ResponseEntity<?> findTongTienByCoDongId(@PathVariable Long id, @PathVariable LocalDate startDate) {
        return new ResponseEntity<>(tongTienCoDongService.findTongTienByCoDongAndNgayTinhTien(id, startDate), HttpStatus.OK);
    }
    @PutMapping("{id}/tcd")
    public ResponseEntity<?> UpdateTongTienCoDongId(@PathVariable Long id, @RequestBody ChungChi chungChi) {
        tongTienCoDongService.saveChungChiCoDong(chungChi, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
