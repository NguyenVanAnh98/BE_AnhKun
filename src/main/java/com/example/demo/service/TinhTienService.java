package com.example.demo.service;

import com.example.demo.model.TinhTien;
import com.example.demo.repository.ITinhTienRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TinhTienService implements ITinhTienService {

    @Autowired
    private ITinhTienRepository tinhTienRepository;

    @Override
    public List<TinhTien> getAllTinhTien() {
        return tinhTienRepository.findAll();
    }

    @Override
    public Optional<TinhTien> getTinhTienById(Long id) {
        return tinhTienRepository.findById(id);
    }

    @Override
    public TinhTien saveOrUpdateTinhTien(TinhTien tinhTien) {
        // Truy cập các giá trị từ thực thể KhachHang
        int giaDo = tinhTien.getKhachHang().getGiaDo();
        int giaBanh = tinhTien.getKhachHang().getGiaBanh();

        // Tính toán các giá trị cần thiết
        tinhTien.setThanhtienAnThua((double) (giaDo * tinhTien.getAnThuaKhachHang()));
        tinhTien.setThanhtienCoBanh((double) (tinhTien.getCoBanhKhachHang() * giaDo * giaBanh / 1000));

        // Lưu lại thực thể TinhTien
        return tinhTienRepository.save(tinhTien);
    }

    @Override
    public void deleteTinhTien(Long id) {
        tinhTienRepository.deleteById(id);
    }
}
