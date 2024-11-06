package com.example.demo.service;

import com.example.demo.model.ChungChiNguoiTheo;
import com.example.demo.model.TongTienNguoiTheo;
import com.example.demo.model.dto.ChungChi;
import com.example.demo.model.dto.TongTienNguoiTheoDTO;
import com.example.demo.repository.IChungChiNguoiTheoRepository;
import com.example.demo.repository.INguoiTheoRepository;
import com.example.demo.repository.ITongTienNguoiTheoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ChungChiNguoiTheoService implements IChungChiNguoiTheoService {
    @Autowired
    private IChungChiNguoiTheoRepository chungChiNguoiTheoRepository;
    @Autowired
    private ITongTienNguoiTheoRepository tongTienNguoiTheoRepository;
    @Autowired
    private INguoiTheoRepository nguoiTheoRepository;

    @Override
    public void saveChungChiNguoiTheo(Integer chungChi, LocalDate ngayChungChi, Long id) {
        ChungChiNguoiTheo chungChiNguoiTheo = new ChungChiNguoiTheo();
        TongTienNguoiTheo tongTienNguoiTheo1 = tongTienNguoiTheoRepository.findById(id).orElseThrow(() -> new RuntimeException("TongTienNguoiTheo not found"));
        chungChiNguoiTheo.setChungChiNguoiTheo(chungChi);
        chungChiNguoiTheo.setNgayChungChi(ngayChungChi);
        chungChiNguoiTheo.setTongTienNguoiTheo(tongTienNguoiTheo1);
        chungChiNguoiTheoRepository.save(chungChiNguoiTheo);

        TongTienNguoiTheo tongTienNguoiTheo = tongTienNguoiTheoRepository.findById(tongTienNguoiTheoRepository.findById(id).get().getId()).orElseThrow(() -> new RuntimeException("TongTienNguoiTheo not found"));
        tongTienNguoiTheo.setChungChiNguoiTheo(tongTienNguoiTheo.getChungChiNguoiTheo() + chungChi);
        tongTienNguoiTheo.setTienConLaiNguoiTheo(tongTienNguoiTheo.getTienConLaiNguoiTheo() - chungChi);
        tongTienNguoiTheoRepository.save(tongTienNguoiTheo);

    }

    @Override
    public List<ChungChiNguoiTheo> getChungChiDetailsByNguoiTheoId(Long nguoiTheoId) {
        return chungChiNguoiTheoRepository.findByTongTienNguoiTheo_Id(nguoiTheoId);
    }
}

