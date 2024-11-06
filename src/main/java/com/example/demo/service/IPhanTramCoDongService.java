package com.example.demo.service;

import com.example.demo.model.PhanTramCoDong;

import java.util.List;
import java.util.Optional;

public interface IPhanTramCoDongService {
    PhanTramCoDong save (PhanTramCoDong phanTramCoDong);
    Optional<PhanTramCoDong> findById (Long id);
    List <PhanTramCoDong> findAll ();
    void deleteById (Long id);
    List<PhanTramCoDong> findAllByIdCoDong (Long id);
}
