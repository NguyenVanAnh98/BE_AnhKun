package com.example.demo.service;

import com.example.demo.model.TinhTienNguoiTheo;
import com.example.demo.model.dto.ChungChi;
import com.example.demo.model.dto.TinhTienNguoiTheoDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ITinhTienNguoiTheoService {
    TinhTienNguoiTheo save (TinhTienNguoiTheo tinhTienNguoiTheo);
    Optional<TinhTienNguoiTheo> findById(Long id);
    List<TinhTienNguoiTheo> findAll();
    void deleteById(Long id);
    List<TinhTienNguoiTheo> findAllByNguoiTheoId(Long id, LocalDate startDate);
    TinhTienNguoiTheoDTO findTopByNguoiTheoId(Long id);
    void saveChungChiNguoiTheo (ChungChi chungChi, Long id);


}
