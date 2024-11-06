package com.example.demo.service;

import com.example.demo.model.NguoiTheo;
import com.example.demo.model.TinhTienNguoiTheo;
import com.example.demo.model.TongTienNguoiTheo;
import com.example.demo.model.dto.ChungChi;
import com.example.demo.model.dto.TinhTienNguoiTheoDTO;
import com.example.demo.model.dto.TongTienNguoiTheoDTO;
import com.example.demo.repository.INguoiTheoRepository;
import com.example.demo.repository.ITongTienNguoiTheoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TongTienNguoiTheoService implements ITongTienNguoiTheoService {
    @Autowired
    private ITongTienNguoiTheoRepository tongTienNguoiTheoRepository;
    @Autowired
    private INguoiTheoRepository nguoiTheoRepository;

    @Override
    public TinhTienNguoiTheo save(TongTienNguoiTheo tongTienNguoiTheo) {
        return null;
    }

    @Override
    public Optional<TongTienNguoiTheo> findById(Long id) {
        return tongTienNguoiTheoRepository.findById(id);
    }

    @Override
    public List<TongTienNguoiTheo> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<TongTienNguoiTheo> findAllByNguoiTheoId(Long id) {
        return List.of();
    }

    @Override
    public TongTienNguoiTheoDTO findTopByNguoiTheoId(Long id) {
        return tongTienNguoiTheoRepository.findTopByIdNguoiTheo(id);
    }

    @Override
    public void saveChungChiNguoiTheo(ChungChi chungChi, Long id) {
       TongTienNguoiTheoDTO tongTienNguoiTheoDTO = tongTienNguoiTheoRepository.findTopByIdNguoiTheo(id);
       TongTienNguoiTheo tongTienNguoiTheo = tongTienNguoiTheoRepository.findById(tongTienNguoiTheoDTO.getId()).orElseThrow(() -> new RuntimeException("TinhTienNguoiTheo not found"));

       tongTienNguoiTheo.setChungChiNguoiTheo(tongTienNguoiTheo.getChungChiNguoiTheo()+ chungChi.getChungchi());
       tongTienNguoiTheo.setTienConLaiNguoiTheo(tongTienNguoiTheo.getTienConLaiNguoiTheo() - chungChi.getChungchi());
       tongTienNguoiTheoRepository.save(tongTienNguoiTheo);
    }

    @Override
    public TongTienNguoiTheo findTongTienByNguoiTheoAndNgayTinhTien(Long id, LocalDate ngayTinhTien) {
        NguoiTheo nguoiTheo = nguoiTheoRepository.findById(id).orElseThrow(() -> new RuntimeException("NguoiTheo not found"));
        TongTienNguoiTheo tongTienNguoiTheo = tongTienNguoiTheoRepository.findTongTienByNguoiTheoAndNgayTinhTien(nguoiTheo, ngayTinhTien);

        return tongTienNguoiTheo;
    }


}
