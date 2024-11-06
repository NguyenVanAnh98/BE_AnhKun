package com.example.demo.service;

import com.example.demo.model.ChungChiCoDong;
import com.example.demo.model.TongTienCoDong;
import com.example.demo.repository.IChungChiCoDongRepository;
import com.example.demo.repository.ITongTienCoDongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ChungChiCoDongService implements IChungChiCoDongService {
    @Autowired
    private IChungChiCoDongRepository chungChiCoDongRepository;
    @Autowired
    private ITongTienCoDongRepository tongTienCoDongRepository;

    @Override
    public void saveChungChiCoDong(Integer chungChi, LocalDate ngayChungChi, Long id) {
        ChungChiCoDong chungChiCoDong = new ChungChiCoDong();
        TongTienCoDong tongtienCoDong1 = tongTienCoDongRepository.findById(id).orElseThrow(() -> new RuntimeException("TongTienCoDong not found"));
        chungChiCoDong.setChungChiCoDong(chungChi);
        chungChiCoDong.setNgayChungChi(ngayChungChi);
        chungChiCoDong.setTongTienCoDong(tongtienCoDong1);
        chungChiCoDongRepository.save(chungChiCoDong);

        TongTienCoDong tongTienCoDong = tongTienCoDongRepository.findById(tongTienCoDongRepository.findById(id).get().getId()).orElseThrow(() -> new RuntimeException("TongTienCoDong not found"));
        tongTienCoDong.setChungChiCoDong(tongTienCoDong.getChungChiCoDong()+ chungChi);
        tongTienCoDong.setTienConLaiCoDong(tongTienCoDong.getTienConLaiCoDong() - chungChi);
        tongTienCoDongRepository.save(tongTienCoDong);

    }

    @Override
    public List<ChungChiCoDong> getChungChiDetailsByCoDongId(Long coDongId) {
        return chungChiCoDongRepository.findByTongTienCoDong_Id(coDongId);
    }
}
