package com.example.demo.service;

import com.example.demo.model.NguoiTheo;
import com.example.demo.model.TinhTienNguoiTheo;
import com.example.demo.model.dto.ChungChi;
import com.example.demo.model.dto.TinhTienNguoiTheoDTO;
import com.example.demo.repository.INguoiTheoRepository;
import com.example.demo.repository.ITinhTienNguoiTheoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
public class TinhTienNguoiTheoService implements ITinhTienNguoiTheoService {
    @Autowired
    private ITinhTienNguoiTheoRepository tinhTienNguoiTheoRepository;
    @Autowired
    private INguoiTheoRepository nguoiTheoRepository;
    @Override
    public TinhTienNguoiTheo save(TinhTienNguoiTheo tinhTienNguoiTheo) {

        return save(tinhTienNguoiTheo);
    }

    @Override
    public Optional<TinhTienNguoiTheo> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<TinhTienNguoiTheo> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<TinhTienNguoiTheo> findAllByNguoiTheoId(Long id, LocalDate startDate) {
        NguoiTheo nguoiTheo = nguoiTheoRepository.findById(id).orElseThrow(() -> new RuntimeException("NguoiTheo not found"));

        return tinhTienNguoiTheoRepository.findAllByNguoiTheoAndNgayTinhTien(nguoiTheo , startDate);
    }

    @Override
    public TinhTienNguoiTheoDTO findTopByNguoiTheoId(Long id) {

        return tinhTienNguoiTheoRepository.findTopByIdKhachHang(id);
    }

    @Override
    public void saveChungChiNguoiTheo(ChungChi chungChi, Long id) {
        TinhTienNguoiTheoDTO tinhTienNguoiTheoDTO = tinhTienNguoiTheoRepository.findTopByIdKhachHang(id);
        TinhTienNguoiTheo tinhTienNguoiTheo = tinhTienNguoiTheoRepository.findById(tinhTienNguoiTheoDTO.getId()).orElseThrow(() -> new RuntimeException("TinhTienNguoiTheo not found"));;

//        tinhTienNguoiTheo.setChungChiNguoiTheo(chungChi.getChungchi()+ (tinhTienNguoiTheoDTO.getChungChiNguoiTheo() == null ? 0 : tinhTienNguoiTheo.getChungChiNguoiTheo()));
//        tinhTienNguoiTheo.setTienConLaiNguoiTheo(tinhTienNguoiTheoDTO.getTienConLaiNguoiTheo() - chungChi.getChungchi());
        tinhTienNguoiTheoRepository.save(tinhTienNguoiTheo);
    }
}
