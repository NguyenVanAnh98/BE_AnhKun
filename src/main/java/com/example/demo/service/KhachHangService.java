package com.example.demo.service;

import com.example.demo.model.KhachHang;

import com.example.demo.model.dto.res.KhachHangResponseDTO;
import com.example.demo.repository.IKhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KhachHangService implements IKhachHangService {
    @Autowired
    private IKhachHangRepository khachHangRepository;


    @Override
    public KhachHang save(KhachHang khachHang) {
        return khachHangRepository.save(khachHang);
    }

    @Override
    public Optional<KhachHang> findById(Long id) {
        return khachHangRepository.findById(id);
    }

    @Override
    public List<KhachHang> findAll() {
        return khachHangRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        khachHangRepository.deleteById(id);
    }
    public List<KhachHangResponseDTO> findKhachHangByLoai(String loai) {
        List<KhachHang> khachHangList = khachHangRepository.findByLoai_TenLoai(loai);
        return khachHangList.stream()
                .map(KhachHangResponseDTO::new)
                .collect(Collectors.toList());
    }



}