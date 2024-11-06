package com.example.demo.controller;

import com.example.demo.model.dto.ChungChi;
import com.example.demo.model.dto.TinhTienNguoiTheoDTO;
import com.example.demo.service.TinhTienNguoiTheoService;
import com.example.demo.service.TinhTienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tinhtiennguoitheo")
public class TinhTienNguoiTheoController {
    @Autowired
    private TinhTienNguoiTheoService tinhTienNguoiTheoService;
    @Autowired
    private TinhTienService tinhTienService;

    @GetMapping("{id}/nt")
    public ResponseEntity<?> findTopByNguoiTheoId(@PathVariable Long id){
        return new ResponseEntity<>(tinhTienNguoiTheoService.findTopByNguoiTheoId(id), HttpStatus.OK);
    }
    @PutMapping("{id}/nt")
    public ResponseEntity<?> UpdateTinhTienNguoiTheoId (@PathVariable Long id, @RequestBody ChungChi chungChi ){
        tinhTienNguoiTheoService.saveChungChiNguoiTheo(chungChi, id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
