package com.example.demo.service;

import com.example.demo.model.Loai;
import com.example.demo.repository.ILoaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoaiService implements ILoaiService {

    @Autowired
    private ILoaiRepository loaiRepository;

    @Override
    public Loai save(Loai loai) {
        return loaiRepository.save(loai);
    }

    @Override
    public Optional<Loai> findById(Long id) {
        return loaiRepository.findById(id);
    }

    @Override
    public List<Loai> findAll() {
        return loaiRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        loaiRepository.deleteById(id);
    }
}
