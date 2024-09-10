package com.example.demo.service;

import com.example.demo.model.TinhTienNguoiTheo;

import java.util.List;
import java.util.Optional;

public interface ITinhTienNguoiTheoService {
    TinhTienNguoiTheo save (TinhTienNguoiTheo tinhTienNguoiTheo);
    Optional<TinhTienNguoiTheo> findById(Long id);
    List<TinhTienNguoiTheo> findAll();
    void deleteById(Long id);
    List<TinhTienNguoiTheo> findAllByNguoiTheoId(Long id);

}
