package com.example.demo.controller;

import com.example.demo.model.TinhTien;
import com.example.demo.model.dto.req.TinhTienRequestDTO;
import com.example.demo.model.dto.res.KhachHangResponseDTO;
import com.example.demo.service.ITinhTienService;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tinhtien")
public class TinhTienController {

    @Autowired
    private ITinhTienService tinhTienService;
    @Autowired
    private KhachHangService khachHangService;

    // Lấy danh sách tất cả các TinhTien
    @GetMapping("/all")
    public List<TinhTien> getAllTinhTien() {
        return tinhTienService.getAllTinhTien();
    }

    // Lấy thông tin chi tiết của một TinhTien theo ID
    @GetMapping("/{id}")
    public ResponseEntity<TinhTien> getTinhTienById(@PathVariable Long id) {
        Optional<TinhTien> tinhTien = tinhTienService.getTinhTienById(id);
        return tinhTien.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Tạo mới hoặc cập nhật một TinhTien
    @PostMapping("/save")
    public ResponseEntity<List<TinhTien>> saveOrUpdateTinhTien(@RequestBody List<TinhTienRequestDTO> tinhTienRequestDTO) {
        tinhTienService.saveOrUpdateTinhTien(tinhTienRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Xóa một TinhTien theo ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTinhTien(@PathVariable Long id) {
        tinhTienService.deleteTinhTien(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("{id}/kh")
    public ResponseEntity<?> findTopTinhTinhByKhId(@PathVariable Long id){

        return new ResponseEntity<>(tinhTienService.findTopTinhTienByKhachHangid(id),HttpStatus.OK);
    }

}
