package com.example.demo.service;

import com.example.demo.model.TinhTien;

import java.util.List;
import java.util.Optional;

public interface ITinhTienService {
    List<TinhTien> getAllTinhTien();

    Optional<TinhTien> getTinhTienById(Long id);

    TinhTien saveOrUpdateTinhTien(TinhTien tinhTien);

    void deleteTinhTien(Long id);
}
