package com.example.demo.controller;

import com.example.demo.model.CoDong;
import com.example.demo.model.PhanTramCoDong;
import com.example.demo.model.dto.KhachHangDTO;
import com.example.demo.model.dto.TinhTienDTO;
import com.example.demo.model.dto.req.CoDongRequesDTO;
import com.example.demo.model.dto.res.CoDongDetailResponseDTO;
import com.example.demo.model.dto.res.CoDongResponseDTO;
import com.example.demo.repository.ICoDongRepository;
import com.example.demo.service.ICoDongService;
import com.example.demo.service.PhanTramCoDongService;
import com.example.demo.service.TinhTienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/codong")
public class CoDongController {
    @Autowired
    private ICoDongService coDongService;
    @Autowired
    private ICoDongRepository coDongRepository;
    @Autowired
    private PhanTramCoDongService phanTramCoDongService;
    @Autowired
    private TinhTienService tinhTienService;

    @PostMapping
    public ResponseEntity<CoDongResponseDTO> createCoDong(@RequestBody CoDongRequesDTO requesDTO) {
        if (requesDTO == null || requesDTO.getName() == null || requesDTO.getName().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        CoDong coDong = new CoDong();
        coDong.setName(requesDTO.getName());

        CoDong savedCoDong = coDongService.save(coDong);
        CoDongResponseDTO responseDTO = new CoDongResponseDTO(savedCoDong);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CoDongResponseDTO> updateCoDong(@PathVariable Long id, @RequestBody CoDongRequesDTO requesDTO) {
        if (requesDTO == null || requesDTO.getName() == null || requesDTO.getName().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        Optional<CoDong> coDongOptional = coDongService.findById(id);
        if (!coDongOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        CoDong coDong = coDongOptional.get();
        coDong.setName(requesDTO.getName());

        CoDong updatedCoDong = coDongService.save(coDong);
        CoDongResponseDTO responseDTO = new CoDongResponseDTO(updatedCoDong);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoDong(@PathVariable Long id) {
        Optional<CoDong> coDongOptional = coDongService.findById(id);
        if (!coDongOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        coDongService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<CoDongResponseDTO> getCoDongById(@PathVariable Long id) {
        Optional<CoDong> coDongOptional = coDongService.findById(id);
        return coDongOptional.map(coDong -> ResponseEntity.ok(new CoDongResponseDTO(coDong)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @GetMapping
    public ResponseEntity<List<CoDongResponseDTO>> getAllCoDong() {
        List<CoDong> coDongList = coDongService.findAll();
        if (coDongList.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        List<CoDongResponseDTO> responseDTOList = coDongList.stream()
                .map(CoDongResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOList);
    }
    @GetMapping("/{id}/detail/{date}")
    public ResponseEntity<CoDongDetailResponseDTO> getCoDongDetail(@PathVariable Long id, @PathVariable LocalDate date) {
        Optional<CoDong> coDongOptional = coDongService.findById(id);
        if (!coDongOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        CoDong coDong = coDongOptional.get();
        List<PhanTramCoDong> phanTramCoDongList = phanTramCoDongService.findAllByIdCoDong(id);
        List<KhachHangDTO> khachHangDTOList = new ArrayList<>();
        for (PhanTramCoDong phanTramCoDong : phanTramCoDongList) {
            List<TinhTienDTO> tinhTienList = tinhTienService.findAllTinhTienByKhachHang(phanTramCoDong.getKhachHang().getId());
            List<TinhTienDTO> filteredTinhTienList = tinhTienList.stream()
                    .filter(tinhTien -> tinhTien.getNgayDauTuan().equals(date))
                    .collect(Collectors.toUnmodifiableList());
            if (!filteredTinhTienList.isEmpty()) {
                KhachHangDTO kh = new KhachHangDTO();
                kh.setName(phanTramCoDong.getKhachHang().getName());
                kh.setGiaBanh(phanTramCoDong.getKhachHang().getGiaBanh());
                kh.setGiaDo(phanTramCoDong.getKhachHang().getGiaDo());
                kh.setGiaGame(phanTramCoDong.getKhachHang().getGiaGame());
                kh.setPhanTramTheo(phanTramCoDong.getPhanTramTheo());
                kh.setLoai(phanTramCoDong.getKhachHang().getLoai());
                kh.setTinhtien(filteredTinhTienList);
                khachHangDTOList.add(kh);

            }
        }
        CoDongDetailResponseDTO responseDTO = new CoDongDetailResponseDTO(coDong, khachHangDTOList);
        return ResponseEntity.ok(responseDTO);
    }
}


