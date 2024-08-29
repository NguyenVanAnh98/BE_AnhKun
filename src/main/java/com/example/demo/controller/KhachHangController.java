package com.example.demo.controller;


import com.example.demo.model.KhachHang;
import com.example.demo.model.Loai;
import com.example.demo.model.TheoXuKhach;
import com.example.demo.model.dto.req.KhachHangRequestDTO;
import com.example.demo.model.dto.res.KhachHangResponseDTO;
import com.example.demo.service.IKhachHangService;

import com.example.demo.service.ILoaiService;
import com.example.demo.service.INguoiTheoService;
import com.example.demo.service.ITheoXuKhachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/khachhang")
public class KhachHangController {

    @Autowired
    private IKhachHangService khachHangService;

    @Autowired
    private INguoiTheoService nguoiTheoService;

    @Autowired
    private ITheoXuKhachService theoXuKhachService;

    @Autowired
    private ILoaiService loaiService;

    @PostMapping
    public ResponseEntity<KhachHangResponseDTO> createKhachHang(@RequestBody KhachHangRequestDTO requestDTO) {
        // Tạo đối tượng KhachHang từ requestDTO
        KhachHang khachHang = new KhachHang();
        khachHang.setMaKhachHang(requestDTO.getMaKhachHang());
        khachHang.setName(requestDTO.getName());
        khachHang.setGiaDo(requestDTO.getGiaDo());
        khachHang.setGiaBanh(requestDTO.getGiaBanh());
        khachHang.setGiaGame(requestDTO.getGiaGame());

        // Kiểm tra LoaiId có hợp lệ không
        if (requestDTO.getLoaiId() != null) {
            Optional<Loai> loaiOptional = loaiService.findById(requestDTO.getLoaiId());
            if (loaiOptional.isPresent()) {
                khachHang.setLoai(loaiOptional.get());
            } else {
                return ResponseEntity.badRequest().body(null); // Trả về lỗi nếu Loai không tồn tại
            }
        } else {
            return ResponseEntity.badRequest().body(null); // Trả về lỗi nếu LoaiId là null
        }

        KhachHang savedKhachHang = khachHangService.save(khachHang);
        // Xử lý và thiết lập danh sách TheoXuKhach
        if (requestDTO.getTheoXuKHReqDTOS() != null) {
            List<TheoXuKhach> theoXuKhachs = requestDTO.getTheoXuKHReqDTOS().stream().map(dto -> {
                TheoXuKhach theoXuKhach = new TheoXuKhach();

                theoXuKhach.setNguoiTheo(nguoiTheoService.findById(dto.getIdNguoiTheo()).get());
                theoXuKhach.setXuTheo(dto.getXuTheo());
                theoXuKhach.setKhachHang(khachHang); // Liên kết theoXuKhach với khách hàng

                theoXuKhachService.save(theoXuKhach);
                return theoXuKhach;
            }).collect(Collectors.toList());

            khachHang.setTheoXuKhachs(theoXuKhachs);
        }



        KhachHangResponseDTO responseDTO = new KhachHangResponseDTO(savedKhachHang);
        return ResponseEntity.ok(responseDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<KhachHangResponseDTO> updateKhachHang(@PathVariable Long id, @RequestBody KhachHangRequestDTO requestDTO) {
        if (requestDTO == null || requestDTO.getName() == null || requestDTO.getName().isEmpty()) {
            return ResponseEntity.badRequest().body(null); // Trả về 400 Bad Request nếu dữ liệu không hợp lệ
        }

        Optional<KhachHang> khachHangOptional = khachHangService.findById(id);
        if (!khachHangOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Trả về 404 Not Found nếu không tìm thấy khách hàng
        }

        KhachHang khachHang = khachHangOptional.get();
        // Cập nhật thông tin khách hàng
        khachHang.setName(requestDTO.getName());
        khachHang.setGiaDo(requestDTO.getGiaDo());
        khachHang.setGiaBanh(requestDTO.getGiaBanh());
        khachHang.setGiaGame(requestDTO.getGiaGame());
        // Cập nhật các thông tin khác nếu cần

        KhachHang updatedKhachHang = khachHangService.save(khachHang);
        KhachHangResponseDTO responseDTO = new KhachHangResponseDTO(updatedKhachHang);
        return ResponseEntity.ok(responseDTO); // Trả về 200 OK với thông tin khách hàng đã cập nhật
    }

    @GetMapping("/{id}")
    public ResponseEntity<KhachHangResponseDTO> getKhachHangById(@PathVariable Long id) {
        Optional<KhachHang> khachHangOptional = khachHangService.findById(id);
        return khachHangOptional.map(khachHang -> ResponseEntity.ok(new KhachHangResponseDTO(khachHang)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<KhachHangResponseDTO>> getAllKhachHang() {
        List<KhachHang> khachHangList = khachHangService.findAll();
        List<KhachHangResponseDTO> responseDTOList = khachHangList.stream()
                .map(KhachHangResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOList);
    }
    @GetMapping("/ibet")
    public List<KhachHangResponseDTO> getKhachHangIbet() {
        return khachHangService.findKhachHangByLoai("IBET");
    }

    @GetMapping("/sbo")
    public List<KhachHangResponseDTO> getKhachHangSbo() {
        return khachHangService.findKhachHangByLoai("SBO");
    }
}