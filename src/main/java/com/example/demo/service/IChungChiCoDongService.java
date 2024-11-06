package com.example.demo.service;


import com.example.demo.model.ChungChiCoDong;
import com.example.demo.model.dto.ChungChi;

import java.time.LocalDate;
import java.util.List;

public interface IChungChiCoDongService {
    void saveChungChiCoDong(Integer chungChi, LocalDate ngayChungChi, Long id);
    List<ChungChiCoDong>getChungChiDetailsByCoDongId(Long coDongId);
}
