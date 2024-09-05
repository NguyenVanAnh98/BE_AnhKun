package com.example.demo.service;

import com.example.demo.model.TinhTien;
import com.example.demo.model.dto.TinhTienDTO;
import com.example.demo.model.dto.req.TinhTienRequestDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ITinhTienService {
    List<TinhTien> getAllTinhTien();

    Optional<TinhTien> getTinhTienById(Long id);

    List<TinhTien> saveOrUpdateTinhTien(List<TinhTienRequestDTO> tinhTienRequestDTO);

    void deleteTinhTien(Long id);
    List<TinhTienDTO> findAllTinhTienByKhachHang(Long id);
}
