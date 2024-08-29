package com.example.demo.service;

import com.example.demo.model.TheoXuKhach;

import java.util.List;
import java.util.Optional;

public interface ITheoXuKhachService {


        TheoXuKhach save(TheoXuKhach theoXuKhach);
        Optional<TheoXuKhach> findById(Long id);
        List<TheoXuKhach> findAll();
        void deleteById(Long id);
        List<TheoXuKhach> findAllByIdNguoiTheo(Long id);
    }


