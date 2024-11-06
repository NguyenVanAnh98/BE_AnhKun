package com.example.demo.service;

import com.example.demo.model.CoDong;
import com.example.demo.model.TinhTienCoDong;
import com.example.demo.model.dto.ChungChi;
import com.example.demo.model.dto.TinhTienCoDongDTO;
import com.example.demo.repository.ICoDongRepository;
import com.example.demo.repository.ITinhTienCoDongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
public class TinhTienCoDongService implements ITinhTienCoDongService {
    @Autowired
    private ITinhTienCoDongRepository tinhTienCoDongRepository;
    @Autowired
    private ICoDongRepository coDongRepository;
    @Override
    public TinhTienCoDong save(TinhTienCoDong tinhTienCoDong) {
        return save(tinhTienCoDong);
    }

    @Override
    public Optional<TinhTienCoDong> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<TinhTienCoDong> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<TinhTienCoDong> findAllByCoDongId(Long id, LocalDate startDate) {
        CoDong coDong = coDongRepository.findById(id).orElseThrow(() -> new RuntimeException("CoDong not found"));
        return tinhTienCoDongRepository.findAllByCoDongAndNgayTinhTien(coDong , startDate);
    }

    @Override
    public TinhTienCoDongDTO findTopByCoDongId(Long id) {

        return tinhTienCoDongRepository.findTopByIdKhachHang(id);
    }

    @Override
    public void saveChungChiCoDong(ChungChi chungChi, Long id) {
     TinhTienCoDongDTO tinhTienCoDongDTO = tinhTienCoDongRepository.findTopByIdKhachHang(id);
     TinhTienCoDong tinhTienCoDong = tinhTienCoDongRepository.findById(tinhTienCoDongDTO.getId()).orElseThrow(() -> new RuntimeException("TinhTienCoDong not found"));
     tinhTienCoDongRepository.save(tinhTienCoDong);
    }
}
