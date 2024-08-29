package com.example.demo.controller;

import com.example.demo.model.Loai;
import com.example.demo.model.dto.req.LoaiRequestDTO;
import com.example.demo.model.dto.res.LoaiResponseDTO;
import com.example.demo.service.ILoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/loai")
public class LoaiController {

    @Autowired
    private ILoaiService loaiService;

    @PostMapping
    public ResponseEntity<LoaiResponseDTO> createLoai(@RequestBody LoaiRequestDTO requestDTO) {
        Loai loai = new Loai();
        loai.setTenLoai(requestDTO.getTenLoai());
        loai.setPhanTram(requestDTO.getPhanTram());

        Loai savedLoai = loaiService.save(loai);
        LoaiResponseDTO responseDTO = new LoaiResponseDTO(savedLoai);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoaiResponseDTO> updateLoai(@PathVariable Long id, @RequestBody LoaiRequestDTO requestDTO) {
        Optional<Loai> loaiOptional = loaiService.findById(id);
        if (!loaiOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Loai loai = loaiOptional.get();
        loai.setTenLoai(requestDTO.getTenLoai());
        loai.setPhanTram(requestDTO.getPhanTram());

        Loai updatedLoai = loaiService.save(loai);
        LoaiResponseDTO responseDTO = new LoaiResponseDTO(updatedLoai);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoai(@PathVariable Long id) {
        if (!loaiService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        loaiService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoaiResponseDTO> getLoaiById(@PathVariable Long id) {
        Optional<Loai> loaiOptional = loaiService.findById(id);
        return loaiOptional.map(loai -> ResponseEntity.ok(new LoaiResponseDTO(loai)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<LoaiResponseDTO>> getAllLoai() {
        List<Loai> loaiList = loaiService.findAll();
        List<LoaiResponseDTO> responseDTOList = loaiList.stream()
                .map(LoaiResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOList);
    }
}