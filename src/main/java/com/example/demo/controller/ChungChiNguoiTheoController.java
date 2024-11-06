package com.example.demo.controller;

import com.example.demo.model.ChungChiNguoiTheo;
import com.example.demo.model.TongTienNguoiTheo;
import com.example.demo.model.dto.ChungChi;
import com.example.demo.model.dto.TongTienNguoiTheoDTO;
import com.example.demo.service.IChungChiNguoiTheoService;
import com.example.demo.repository.ITongTienNguoiTheoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chungchinguoitheo")
@CrossOrigin("*")
public class ChungChiNguoiTheoController {

    @Autowired
    private IChungChiNguoiTheoService chungChiNguoiTheoService;

    @Autowired
    private ITongTienNguoiTheoRepository tongTienNguoiTheoRepository;

    @PostMapping("/save/{ngayChungChi}/{chungChi}/{id}")
    public ResponseEntity<?> saveChungChiNguoiTheo(@PathVariable Integer chungChi,@PathVariable LocalDate ngayChungChi,
                                                   @PathVariable Long id) {
        chungChiNguoiTheoService.saveChungChiNguoiTheo(chungChi, ngayChungChi, id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @GetMapping("/details/{id}")
    public ResponseEntity<List<ChungChiNguoiTheo>> getChungChiDetails(@PathVariable Long id) {
        List<ChungChiNguoiTheo> chungChiList = chungChiNguoiTheoService.getChungChiDetailsByNguoiTheoId(id);
        return new ResponseEntity<>(chungChiList, HttpStatus.OK);
    }
}


