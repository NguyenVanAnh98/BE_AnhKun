package com.example.demo.controller;

import com.example.demo.model.dto.ChungChi;
import com.example.demo.service.TinhTienNguoiTheoService;
import com.example.demo.service.TinhTienService;
import com.example.demo.service.TongTienNguoiTheoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tongtiennguoitheo")

public class TongTienNguoiTheoController {
    @Autowired
    private TongTienNguoiTheoService tongTienNguoiTheoService;
    @Autowired
    private TinhTienService tinhTienService;
    @Autowired
    private TinhTienNguoiTheoService tinhTienNguoiTheoService;

    @GetMapping("{id}/tnt")
    public ResponseEntity<?> findTopByNguoiTheoId(@PathVariable Long id) {
        return new ResponseEntity<>(tongTienNguoiTheoService.findTopByNguoiTheoId(id), HttpStatus.OK);
    }


    @GetMapping("{id}/{startDate}")
    public ResponseEntity<?> findTongTienByNguoiTheoId(@PathVariable Long id, @PathVariable LocalDate startDate) {
        return new ResponseEntity<>(tongTienNguoiTheoService.findTongTienByNguoiTheoAndNgayTinhTien( id, startDate), HttpStatus.OK);

    }
    @PutMapping("{id}/tnt")
    public ResponseEntity<?> UpdateTongTienNguoiTheoId(@PathVariable Long id, @RequestBody ChungChi chungChi) {
        tongTienNguoiTheoService.saveChungChiNguoiTheo(chungChi, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
   }
