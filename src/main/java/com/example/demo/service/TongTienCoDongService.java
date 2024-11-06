package com.example.demo.service;

import com.example.demo.model.CoDong;
import com.example.demo.model.TongTienCoDong;
import com.example.demo.model.dto.ChungChi;
import com.example.demo.model.dto.TongTienCoDongDTO;
import com.example.demo.model.dto.TongTienNguoiTheoDTO;
import com.example.demo.repository.ICoDongRepository;
import com.example.demo.repository.ITongTienCoDongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TongTienCoDongService implements ITongTienCoDongService {
    @Autowired
    private ITongTienCoDongRepository tongTienCoDongRepository;
    @Autowired
    private ICoDongRepository coDongRepository;
    @Override
    public TongTienCoDong save(TongTienCoDong tongTienCoDong) {
        return null;
    }

    @Override
    public Optional<TongTienCoDong> findById(Long id) {
        return tongTienCoDongRepository.findById(id);
    }

    @Override
    public List<TongTienCoDong> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<TongTienCoDong> findAllByCoDongId(Long id) {
        return List.of();
    }

    @Override
    public TongTienCoDongDTO findTopByCoDongId(Long id) {
        return tongTienCoDongRepository.findTopByIdCoDong(id);
    }

    @Override
    public void saveChungChiCoDong(ChungChi chungChi, Long id) {
        TongTienCoDongDTO tongTienCoDongDTO = tongTienCoDongRepository.findTopByIdCoDong(id);
        TongTienCoDong tongTienCoDong = tongTienCoDongRepository.findById(tongTienCoDongDTO.getId()).orElseThrow(() -> new RuntimeException("TongTienCoDong not found"));
        tongTienCoDong.setChungChiCoDong(tongTienCoDong.getChungChiCoDong()+ chungChi.getChungchi());
        tongTienCoDong.setTienConLaiCoDong(tongTienCoDong.getTienConLaiCoDong() - chungChi.getChungchi());

        tongTienCoDongRepository.save(tongTienCoDong);

    }

    @Override
    public TongTienCoDong findTongTienByCoDongAndNgayTinhTien(Long id, LocalDate ngayTinhTien) {
        CoDong coDong = coDongRepository.findById(id).orElseThrow(() -> new RuntimeException("CoDong not found"));
        TongTienCoDong tongTienCoDong = tongTienCoDongRepository.findTongTienByCoDongAndNgayTinhTien(coDong, ngayTinhTien);
        return tongTienCoDong;
    }
}
