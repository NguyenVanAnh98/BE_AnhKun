package com.example.demo.service;

import com.example.demo.model.CoDong;

import java.util.List;
import java.util.Optional;

public interface ICoDongService {
    CoDong save (CoDong coDong);

    Optional<CoDong> findById(Long id);
    List<CoDong> findAll();
    void deleteById(Long id);
}
