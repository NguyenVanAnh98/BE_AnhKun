package com.example.demo.service;

import com.example.demo.model.TinhTienNguoiTheo;
import com.example.demo.repository.ITinhTienNguoiTheoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TinhTienNguoiTheoService implements ITinhTienNguoiTheoService {
    @Autowired
    private ITinhTienNguoiTheoRepository tinhTienNguoiTheoRepository;
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
    public List<TinhTienNguoiTheo> findAllByNguoiTheoId(Long id) {
        return List.of();
    }
}
