package com.example.demo.service;

import com.example.demo.model.ChungChiNguoiTheo;
import com.example.demo.model.TongTienNguoiTheo;
import com.example.demo.model.dto.ChungChi;
import com.example.demo.model.dto.TongTienNguoiTheoDTO;

import java.time.LocalDate;
import java.util.List;

public interface IChungChiNguoiTheoService {

    void saveChungChiNguoiTheo(Integer chungChi, LocalDate ngayChungChi, Long id);
    List<ChungChiNguoiTheo> getChungChiDetailsByNguoiTheoId(Long nguoiTheoId);


}
