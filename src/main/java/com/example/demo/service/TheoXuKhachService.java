package com.example.demo.service;

import com.example.demo.model.NguoiTheo;
import com.example.demo.model.TheoXuKhach;
import com.example.demo.repository.INguoiTheoRepository;
import com.example.demo.repository.ITheoXuKhachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheoXuKhachService implements ITheoXuKhachService {

    @Autowired
    private ITheoXuKhachRepository theoXuKhachRepository;
    @Autowired
    private INguoiTheoRepository nguoiTheoRepository;

    @Override
    public TheoXuKhach save(TheoXuKhach theoXuKhach) {
        return theoXuKhachRepository.save(theoXuKhach);
    }

    @Override
    public Optional<TheoXuKhach> findById(Long id) {
        return theoXuKhachRepository.findById(id);
    }

    @Override
    public List<TheoXuKhach> findAll() {
        return theoXuKhachRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        theoXuKhachRepository.deleteById(id);
    }

    @Override
    public List<TheoXuKhach> findAllByIdNguoiTheo(Long id) {
       Optional<NguoiTheo>  nguoiTheo = nguoiTheoRepository.findById(id);
        List<TheoXuKhach> xuKhachList = theoXuKhachRepository.findAllByNguoiTheo(nguoiTheo);
        return xuKhachList;
    }
}