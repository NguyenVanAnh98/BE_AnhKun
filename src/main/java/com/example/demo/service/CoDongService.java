package com.example.demo.service;

import com.example.demo.model.CoDong;
import com.example.demo.repository.ICoDongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CoDongService implements ICoDongService {
    @Autowired
    private ICoDongRepository coDongRepository;
    @Override
    public CoDong save(CoDong coDong) {
        return coDongRepository.save(coDong);
    }

    @Override
    public Optional<CoDong> findById(Long id) {
        return coDongRepository.findById(id);
    }

    @Override
    public List<CoDong> findAll() {
        return coDongRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        coDongRepository.deleteById(id);

    }
}
