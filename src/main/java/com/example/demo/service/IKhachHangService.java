package com.example.demo.service;

import com.example.demo.model.KhachHang;

import com.example.demo.model.dto.res.KhachHangResponseDTO;

import java.util.List;
import java.util.Optional;

public interface IKhachHangService {
        KhachHang save(KhachHang khachHang);
        Optional<KhachHang> findById(Long id);
        List<KhachHang> findAll();
        void deleteById(Long id);
       List<KhachHangResponseDTO> findKhachHangByLoai (String loai);
}
