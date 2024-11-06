package com.example.demo.service;

import com.example.demo.model.PhanTramCoDong;
import com.example.demo.model.CoDong;
import com.example.demo.repository.ICoDongRepository;
import com.example.demo.repository.IPhanTramCoDongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhanTramCoDongService implements IPhanTramCoDongService {

    @Autowired
    private IPhanTramCoDongRepository phanTramCoDongRepository;

    @Autowired
    private ICoDongRepository coDongRepository;

    @Override
    public PhanTramCoDong save(PhanTramCoDong phanTramCoDong) {
        return phanTramCoDongRepository.save(phanTramCoDong);
    }

    @Override
    public Optional<PhanTramCoDong> findById(Long id) {
        return phanTramCoDongRepository.findById(id);
    }

    @Override
    public List<PhanTramCoDong> findAll() {
        return phanTramCoDongRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        phanTramCoDongRepository.deleteById(id);
    }

    @Override
    public List<PhanTramCoDong> findAllByIdCoDong(Long id) {
        Optional<CoDong> coDong = coDongRepository.findById(id);
        List<PhanTramCoDong> phanTramCoDongList = phanTramCoDongRepository.findAllByCoDong(coDong);
        return phanTramCoDongList;
    }
}
