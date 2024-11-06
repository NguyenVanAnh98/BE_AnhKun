package com.example.demo.service;

import com.example.demo.model.TongTienCoDong;
import com.example.demo.model.dto.ChungChi;
import com.example.demo.model.dto.TongTienCoDongDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ITongTienCoDongService {
TongTienCoDong save (TongTienCoDong tongTienCoDong);
Optional<TongTienCoDong> findById(Long id);
List<TongTienCoDong> findAll();
void deleteById(Long id);
List<TongTienCoDong> findAllByCoDongId(Long id);
TongTienCoDongDTO findTopByCoDongId(Long id);
void saveChungChiCoDong(ChungChi chungChi, Long id);
TongTienCoDong findTongTienByCoDongAndNgayTinhTien(Long id, LocalDate ngayTinhTien);
}
