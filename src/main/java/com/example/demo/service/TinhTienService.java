package com.example.demo.service;

import com.example.demo.model.KhachHang;
import com.example.demo.model.TinhTien;
import com.example.demo.model.dto.TinhTienDTO;
import com.example.demo.model.dto.req.TinhTienRequestDTO;
import com.example.demo.repository.IKhachHangRepository;

import com.example.demo.repository.ITinhTienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TinhTienService implements ITinhTienService {
    @Autowired
    private ITinhTienRepository tinhTienRepository;
    @Autowired
    private IKhachHangRepository khachHangRepository;

    @Override
    public List<TinhTien> getAllTinhTien() {
        return tinhTienRepository.findAll();
    }

    @Override
    public Optional<TinhTien> getTinhTienById(Long id) {
        return tinhTienRepository.findById(id);
    }

    @Override
    public List<TinhTien> saveOrUpdateTinhTien(List<TinhTienRequestDTO> tinhTienRequestDTO1) {
        List<TinhTien> tinhTien1 = tinhTienRepository.findAll();
        for (TinhTienRequestDTO tinhTienRequestDTO : tinhTienRequestDTO1) {
            TinhTien tinhTien = new TinhTien();
            tinhTien.setNgayDauTuan(tinhTienRequestDTO.getStartDate());
            tinhTien.setNgayCuoiTuan(tinhTienRequestDTO.getEndDate());
            KhachHang khachHang = khachHangRepository.findById(tinhTienRequestDTO.getIdKH()).get();
            tinhTien.setKhachHang(khachHang);
            if (khachHang.getLoai().getId() == 1) {
                tinhTien.setThanhtienIBet(tinhTienRequestDTO.getTyGiaTuan() * khachHang.getLoai().getPhanTram());
                tinhTien.setThanhtienSBo(0.0);
            } else {
                tinhTien.setThanhtienIBet(0.0);
                tinhTien.setThanhtienSBo(tinhTienRequestDTO.getTyGiaTuan() * khachHang.getLoai().getPhanTram());
            }
            tinhTien.setAnThuaKhachHang(tinhTienRequestDTO.getAnThua());
            tinhTien.setCoBanhKhachHang(tinhTienRequestDTO.getCoBanh());
            tinhTien.setCoGameKhachHang(tinhTienRequestDTO.getCoGame());
            tinhTien.setTongCongBanh(Double.valueOf
                    (tinhTienRequestDTO.getAnThua() * khachHang.getGiaDo() +
                            tinhTienRequestDTO.getCoBanh() * khachHang.getGiaDo() * khachHang.getGiaBanh() +
                            tinhTienRequestDTO.getCoGame() * khachHang.getGiaDo() * khachHang.getGiaGame()
                    ));
            tinhTien.setTiSoKhachHang(tinhTienRequestDTO.getTiSo());
            tinhTien.setSoDeKhachHang(tinhTienRequestDTO.getSoDe());
            tinhTien.setTienUngKhachHang(tinhTienRequestDTO.getTienUng());
            tinhTien.setTienGopTuan(tinhTienRequestDTO.getTienGop());
            tinhTien.setTongCongKhachHang(Double.valueOf(
                    tinhTien.getTongCongBanh() +
                            tinhTienRequestDTO.getTienGop() +
                            tinhTienRequestDTO.getTienUng() +
                            tinhTienRequestDTO.getSoDe() +
                            tinhTienRequestDTO.getTiSo()
            ));
            tinhTien.setComm(tinhTienRequestDTO.getComm());
            tinhTien.setTongCongCty(Double.valueOf(
                    (tinhTienRequestDTO.getComm() + tinhTienRequestDTO.getAnThua()) *
                            tinhTienRequestDTO.getTyGiaTuan() * khachHang.getLoai().getPhanTram() / 100
            ));
            tinhTienRepository.save(tinhTien);
            tinhTien1.add(tinhTien);
        }

        return tinhTien1;
    }

    @Override
    public void deleteTinhTien(Long id) {
        tinhTienRepository.deleteById(id);
    }

    @Override
    public List<TinhTienDTO> findAllTinhTienByKhachHang(Long id) {
        KhachHang khachHang = khachHangRepository.findById(id).get();
        List<TinhTien> tinhTiens = tinhTienRepository.findTinhTienByKhachHang(khachHang);
        List<TinhTienDTO> tinhTienDTOS = new ArrayList<>();
        for (TinhTien tinhTien : tinhTiens) {
            TinhTienDTO t = new TinhTienDTO();
            t.setNgayDauTuan(tinhTien.getNgayDauTuan());
            t.setNgayCuoiTuan(tinhTien.getNgayCuoiTuan());
            t.setTyGiaTuan(tinhTien.getTyGiaTuan());
            t.setThanhtienIBet(tinhTien.getThanhtienIBet());
            t.setThanhtienSBo(tinhTien.getThanhtienSBo());
            t.setAnThuaKhachHang(tinhTien.getAnThuaKhachHang());
            t.setCoBanhKhachHang(tinhTien.getCoBanhKhachHang());
            t.setCoGameKhachHang(tinhTien.getCoGameKhachHang());
            t.setTongCongBanh(tinhTien.getTongCongBanh());
            t.setTiSoKhachHang(tinhTien.getTiSoKhachHang());
            t.setSoDeKhachHang(tinhTien.getSoDeKhachHang());
            t.setTienUngKhachHang(tinhTien.getTienUngKhachHang());
            t.setTienGopTuan(tinhTien.getTienGopTuan());
            t.setTongCongKhachHang(tinhTien.getTongCongKhachHang());
            t.setTongCongCty(tinhTien.getTongCongCty());
            t.setComm(tinhTien.getComm());
            tinhTienDTOS.add(t);
        }
        return tinhTienDTOS;
    }
}
