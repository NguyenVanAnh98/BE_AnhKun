package com.example.demo.service;

import com.example.demo.model.TinhTienNguoiTheo;
import com.example.demo.model.TongTienNguoiTheo;
import com.example.demo.model.dto.ChungChi;
import com.example.demo.model.dto.TinhTienNguoiTheoDTO;
import com.example.demo.model.dto.TongTienNguoiTheoDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ITongTienNguoiTheoService {
    TinhTienNguoiTheo save (TongTienNguoiTheo tongTienNguoiTheo);
    Optional<TongTienNguoiTheo> findById(Long id);
    List<TongTienNguoiTheo> findAll();
    void deleteById(Long id);
    List<TongTienNguoiTheo> findAllByNguoiTheoId(Long id);
    TongTienNguoiTheoDTO findTopByNguoiTheoId(Long id);
    void saveChungChiNguoiTheo (ChungChi chungChi, Long id);
    TongTienNguoiTheo findTongTienByNguoiTheoAndNgayTinhTien( Long id , LocalDate ngayTinhTien);




}
