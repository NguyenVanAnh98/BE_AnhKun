package com.example.demo.controller;

import com.example.demo.model.TinhTien;
import com.example.demo.service.ITinhTienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tinhtien")
public class TinhTienController {

    @Autowired
    private ITinhTienService tinhTienService;

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
    public TinhTien saveOrUpdateTinhTien(@RequestBody TinhTien tinhTien) {
        return tinhTienService.saveOrUpdateTinhTien(tinhTien);
    }

    // Xóa một TinhTien theo ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTinhTien(@PathVariable Long id) {
        tinhTienService.deleteTinhTien(id);
        return ResponseEntity.noContent().build();
    }
}
