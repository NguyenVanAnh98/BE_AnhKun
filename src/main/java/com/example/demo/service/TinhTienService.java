package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.model.dto.*;
import com.example.demo.model.dto.req.TinhTienRequestDTO;
import com.example.demo.repository.*;

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
    @Autowired
    private INguoiTheoRepository nguoiTheoRepository;
    @Autowired
    private ITinhTienNguoiTheoRepository tinhTienNguoiTheoRepository;
    @Autowired
    private ITinhTienCoDongRepository tinhTienCoDongRepository;
    @Autowired
    private ITongTienNguoiTheoRepository tongTienNguoiTheoRepository;
    @Autowired
    private ICoDongRepository coDongRepository;
    @Autowired
    private ITongTienCoDongRepository tongTienCoDongRepository;

    @Override
    public List<TinhTien> getAllTinhTien() {
        return tinhTienRepository.findAll();
    }

    @Override
    public Optional<TinhTien> getTinhTienById(Long id) {
        return tinhTienRepository.findById(id);
    }

    @Override
    public List<TinhTien> saveOrUpdateTinhTien(List<TinhTienRequestDTO> tinhTienRequestDTO1 , LocalDate startDate, LocalDate endDate) {
        List<TinhTien> tinhTien1 = tinhTienRepository.findAll();
        for (TinhTienRequestDTO tinhTienRequestDTO : tinhTienRequestDTO1) {
            TinhTien tinhTien = new TinhTien();
            TinhTienDTO tinhTienDTO1 = tinhTienRepository.findTopDTOByKhachHangId(tinhTienRequestDTO.getIdKH());
            tinhTien.setTienCu(tinhTienDTO1 == null ? 0.0 : tinhTienDTO1.getConLai());
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
            tinhTien.setGiaBanh(khachHang.getGiaBanh());
            tinhTien.setGiaDo(khachHang.getGiaDo());
            tinhTien.setGiaGame(khachHang.getGiaGame());
            tinhTien.setTongCongBanh(Double.valueOf
                    ((tinhTienRequestDTO.getAnThua() * khachHang.getGiaDo()) * 1000 +
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
            tinhTien.setConLai(tinhTienDTO1 == null ? tinhTien.getTongCongKhachHang() : tinhTienDTO1.getConLai() + tinhTien.getTongCongKhachHang());
            tinhTien.setComm(tinhTienRequestDTO.getComm());
            tinhTien.setTongCongCty(Double.valueOf(
                    (tinhTienRequestDTO.getComm() + tinhTienRequestDTO.getAnThua()) *
                            tinhTienRequestDTO.getTyGiaTuan() * khachHang.getLoai().getPhanTram() / 100
            ));
            tinhTien.setTyGiaTuan(tinhTienRequestDTO.getTyGiaTuan());

            Double tongTienNguoiTheo = 0.0;
            for (TheoXuKhach theoXuKhach : khachHangRepository.findById(tinhTienRequestDTO.getIdKH()).get().getTheoXuKhachs()) {
                TinhTienNguoiTheo tinhTienNguoiTheo = new TinhTienNguoiTheo();
                tinhTienNguoiTheo.setNgayTinhTien(tinhTienRequestDTO.getStartDate());
                tinhTienNguoiTheo.setNgayKetThuc(tinhTienRequestDTO.getEndDate());
                tinhTienNguoiTheo.setThanhTienNguoiTheo(tinhTien.getTongCongBanh() / khachHang.getGiaDo() * theoXuKhach.getXuTheo());
                tinhTienNguoiTheo.setNguoiTheo((theoXuKhach.getNguoiTheo()));
//                TinhTienNguoiTheoDTO tinhTienNguoiTheoDTO = tinhTienNguoiTheoRepository.findTopByIdKhachHang(theoXuKhach.getKhachHang().getId());
//                tinhTienNguoiTheo.setTienCuNguoiTheo(tinhTienNguoiTheoDTO == null ? 0.0 : tinhTienNguoiTheoDTO.getTienConLaiNguoiTheo());
//                tinhTienNguoiTheo.setTienConLaiNguoiTheo(tinhTienNguoiTheo.getTienCuNguoiTheo() + tinhTienNguoiTheo.getThanhTienNguoiTheo());
                tinhTienNguoiTheo.setIdKhachHang(tinhTienRequestDTO.getIdKH());
                tinhTienNguoiTheoRepository.save(tinhTienNguoiTheo);
            }


            tinhTien.setTienLoiLo(tinhTien.getTongCongBanh() - tongTienNguoiTheo - tinhTien.getTongCongCty());

            Double tongTienCoDong = 0.0;
            for (PhanTramCoDong phanTramCoDong : khachHangRepository.findById(tinhTienRequestDTO.getIdKH()).get().getPhanTramCoDongs()) {
                TinhTienCoDong tinhTienCoDong = new TinhTienCoDong();
                tinhTienCoDong.setNgayTinhTien(tinhTienRequestDTO.getStartDate());
                tinhTienCoDong.setNgayKetThuc(tinhTienRequestDTO.getEndDate());
                tinhTienCoDong.setThanhTienCoDong(tinhTien.getTienLoiLo() / 100 * phanTramCoDong.getPhanTramTheo());
                tinhTienCoDong.setCoDong(phanTramCoDong.getCoDong());
//                TinhTienCoDongDTO tinhTienCoDongDTO = tinhTienCoDongRepository.findTopByIdKhachHang(phanTramCoDong.getKhachHang().getId());
//                tinhTienCoDong.setTienCuCoDong(tinhTienCoDongDTO == null ? 0.0 : tinhTienCoDongDTO.getTienConLaiCoDong());
//                tinhTienCoDong.setTienConLaiCoDong(tinhTienCoDong.getTienCuCoDong() + tinhTienCoDong.getThanhTienCoDong());
                tinhTienCoDong.setIdKhachHang(tinhTienRequestDTO.getIdKH());
                tinhTienCoDongRepository.save(tinhTienCoDong);
                tongTienCoDong += tinhTienCoDong.getThanhTienCoDong();
            }

            tinhTienRepository.save(tinhTien);
            tinhTien1.add(tinhTien);
        }


        List<NguoiTheo> nguoiTheoList = nguoiTheoRepository.findAll();
        for (NguoiTheo nguoiTheo : nguoiTheoList) {
            Double TongTienNguoiTheo = 0.0;
            for (TinhTienNguoiTheo tinhTienNguoiTheo : tinhTienNguoiTheoRepository.findAllByNguoiTheoAndNgayTinhTien(nguoiTheo,startDate)) {
                TongTienNguoiTheo += tinhTienNguoiTheo.getThanhTienNguoiTheo();

            }
            TongTienNguoiTheo tongTienNguoiTheo = new TongTienNguoiTheo();
            tongTienNguoiTheo.setNgayTinhTien(startDate);
            tongTienNguoiTheo.setNgayKetThuc(endDate);
            tongTienNguoiTheo.setChungChiNguoiTheo(0);
            TongTienNguoiTheoDTO tongTienNguoiTheo1 = tongTienNguoiTheoRepository.findTopByIdNguoiTheo(nguoiTheo.getId());
            tongTienNguoiTheo.setTienCuNguoiTheo(tongTienNguoiTheo1 == null ? 0.0 : tongTienNguoiTheo1.getTienConLaiNguoiTheo());
            tongTienNguoiTheo.setTienConLaiNguoiTheo(tongTienNguoiTheo.getTienCuNguoiTheo() + TongTienNguoiTheo - Double.valueOf(tongTienNguoiTheo.getChungChiNguoiTheo()));
            tongTienNguoiTheo.setNguoiTheo(nguoiTheo);
            tongTienNguoiTheo.setTongTienNguoiTheo(TongTienNguoiTheo);
            tongTienNguoiTheoRepository.save(tongTienNguoiTheo);
        }

        List<CoDong> coDongList = coDongRepository.findAll();
        for (CoDong coDong : coDongList) {
            Double TongTienCoDong = 0.0;
            for (TinhTienCoDong tinhTienCoDong : tinhTienCoDongRepository.findAllByCoDongAndNgayTinhTien(coDong,startDate)) {
                TongTienCoDong += tinhTienCoDong.getThanhTienCoDong();
            }
            TongTienCoDong tongTienCoDong = new TongTienCoDong();
            tongTienCoDong.setNgayTinhTien(startDate);
            tongTienCoDong.setNgayKetThuc(endDate);
            tongTienCoDong.setChungChiCoDong(0);
            TongTienCoDongDTO tongTienCoDong1 = tongTienCoDongRepository.findTopByIdCoDong(coDong.getId());
            tongTienCoDong.setTienCuCoDong(tongTienCoDong1 == null ? 0.0 : tongTienCoDong1.getTienConLaiCoDong());
            tongTienCoDong.setTienConLaiCoDong(tongTienCoDong.getTienCuCoDong()+ TongTienCoDong - Double.valueOf(tongTienCoDong.getChungChiCoDong()));
            tongTienCoDong.setCoDong(coDong);
            tongTienCoDong.setTongTienCoDong(TongTienCoDong);
            tongTienCoDongRepository.save(tongTienCoDong);
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
            t.setChungChi(tinhTien.getChungChi());
            t.setTienCu(tinhTien.getTienCu());
            t.setConLai(tinhTien.getConLai());
            t.setTienLoiLo(tinhTien.getTienLoiLo());
            t.setGiaBanh(tinhTien.getGiaBanh());
            t.setGiaDo(tinhTien.getGiaDo());
            t.setGiaGame(tinhTien.getGiaGame());

            tinhTienDTOS.add(t);
        }
        return tinhTienDTOS;
    }

    @Override
    public TinhTienDTO findTopTinhTienByKhachHangid(Long id) {
        return tinhTienRepository.findTopDTOByKhachHangId(id);
    }

    @Override
    public TinhTien findTienConlaiByKhachHangId(Long id) {
        return null;
    }

    @Override
    public List<TinhTienDTO> findAllTinhTienByNgayDauTuanAndKhachHang(LocalDate date, Long id) {
        List<TinhTien> tinhTiens = tinhTienRepository.findAllByNgayDauTuanAndKhachHang(date, khachHangRepository.findById(id).get());
        List<TinhTienDTO> tinhTienDTOS = new ArrayList<>();
        for (TinhTien tt : tinhTiens) {
            TinhTienDTO t = new TinhTienDTO(tt);
            tinhTienDTOS.add(t);
        }
        return tinhTienDTOS;
    }

    @Override
    public void saveChungChi(ChungChi chungchi, Long id) {
        TinhTienDTO tinhTienDTO1 = tinhTienRepository.findTopDTOByKhachHangId(id);
        TinhTien tinhTien2 = tinhTienRepository.findById(tinhTienDTO1.getId()).orElseThrow(() -> new RuntimeException("TinhTien not found"));


        // Cập nhật các giá trị cho tinhTien2
        tinhTien2.setChungChi(chungchi.getChungchi() + (tinhTienDTO1.getChungChi() == null ? 0 : tinhTienDTO1.getChungChi()));
        tinhTien2.setConLai(tinhTienDTO1.getTongCongKhachHang() - chungchi.getChungchi() - (tinhTienDTO1.getChungChi() == null ? 0 : tinhTienDTO1.getChungChi()) + tinhTienDTO1.getTienCu());

        // Lưu lại thay đổi vào repository
        tinhTienRepository.save(tinhTien2);
    }


}

