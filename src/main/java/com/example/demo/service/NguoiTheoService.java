package com.example.demo.service;

import com.example.demo.model.NguoiTheo;
import com.example.demo.repository.INguoiTheoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NguoiTheoService implements INguoiTheoService {

    @Autowired
    private INguoiTheoRepository nguoiTheoRepository;

    @Override
    public NguoiTheo save(NguoiTheo nguoiTheo) {
        return nguoiTheoRepository.save(nguoiTheo);
    }

    @Override
    public Optional<NguoiTheo> findById(Long id) {
        return nguoiTheoRepository.findById(id);
    }

    @Override
    public List<NguoiTheo> findAll() {
        return nguoiTheoRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        nguoiTheoRepository.deleteById(id);
    }

}