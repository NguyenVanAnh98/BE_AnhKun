package com.example.demo.service;

import com.example.demo.model.NguoiTheo;
import com.example.demo.model.dto.res.NguoiTheoDetailResponseDTO;
import com.example.demo.repository.INguoiTheoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Override
    public  NguoiTheoDetailResponseDTO findByNnguoiTheoId(Long id) {
        Optional<NguoiTheo> nguoiTheo = nguoiTheoRepository.findById(id);
        if(nguoiTheo.isPresent()){
//            NguoiTheoDetailResponseDTO nguoiTheoDetailResponseDTO = new NguoiTheoDetailResponseDTO();
//            return nguoiTheoDetailResponseDTO;
        }
        else{
            return null;
        }
        return null;
    }
}