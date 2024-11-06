package com.example.demo.service;

import com.example.demo.model.TinhTienCoDong;
import com.example.demo.model.dto.ChungChi;
import com.example.demo.model.dto.TinhTienCoDongDTO;
import com.example.demo.model.dto.res.PhanTramCoDongResponseDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ITinhTienCoDongService {
    TinhTienCoDong save(TinhTienCoDong tinhTienCoDong);

    Optional<TinhTienCoDong> findById(Long id);
    List<TinhTienCoDong> findAll();
    void deleteById(Long id);
    List<TinhTienCoDong> findAllByCoDongId(Long id, LocalDate startDate);
    TinhTienCoDongDTO findTopByCoDongId(Long id);
    void saveChungChiCoDong(ChungChi chungChi, Long id);
}
