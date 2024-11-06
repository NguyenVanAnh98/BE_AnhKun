package com.example.demo.controller;

import com.example.demo.model.ChungChiCoDong;
import com.example.demo.model.ChungChiNguoiTheo;
import com.example.demo.repository.IChungChiCoDongRepository;
import com.example.demo.repository.ITongTienCoDongRepository;
import com.example.demo.service.IChungChiCoDongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/chungchicodong")
@CrossOrigin("*")
public class ChungChiCoDongController {
    @Autowired
    private IChungChiCoDongService chungChiCoDongService;
    @Autowired
    private ITongTienCoDongRepository tongTienCoDongRepository;
    @PostMapping("/save/{ngayChungChi}/{chungChi}/{id}")
    public ResponseEntity<?> saveChungChiCoDong(@PathVariable Integer chungChi, @PathVariable LocalDate ngayChungChi,
                                                @PathVariable Long id) {
        chungChiCoDongService.saveChungChiCoDong(chungChi, ngayChungChi, id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
    @GetMapping("/details/{id}")
    public ResponseEntity<List<ChungChiCoDong>> getChungChiDetails(@PathVariable Long id) {
        List<ChungChiCoDong> chungChiList = chungChiCoDongService.getChungChiDetailsByCoDongId(id);
        return new ResponseEntity<>(chungChiList, HttpStatus.OK);
    }
}
