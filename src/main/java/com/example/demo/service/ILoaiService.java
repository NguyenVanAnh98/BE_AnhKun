package com.example.demo.service;

import com.example.demo.model.Loai;

import java.util.List;
import java.util.Optional;

public interface ILoaiService {
    Loai save(Loai loai);
    Optional<Loai> findById(Long id);
    List<Loai> findAll();
    void deleteById(Long id);
}
