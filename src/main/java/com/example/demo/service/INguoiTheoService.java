package com.example.demo.service;

import com.example.demo.model.NguoiTheo;
import com.example.demo.model.dto.res.NguoiTheoDetailResponseDTO;

import java.util.List;
import java.util.Optional;

public interface INguoiTheoService {

        NguoiTheo save(NguoiTheo nguoiTheo);

        Optional<NguoiTheo> findById(Long id);

        List<NguoiTheo> findAll();

        void deleteById(Long id);
        NguoiTheoDetailResponseDTO findByNnguoiTheoId (Long id);

    }

