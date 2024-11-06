package com.example.demo.model.dto;

import com.example.demo.model.CoDong;
import com.example.demo.model.TinhTienCoDong;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter

public class TinhTienCoDongDTO {
    private Long id;
    private Double tienCuCoDong;
    private Integer chungChiCoDong;
    private Double tienConLaiCoDong;
    private LocalDate ngayTinhTien;
    private LocalDate ngayKetThuc;
    private CoDong coDong;
    private Double thanhTienCoDong;
    private Integer giaDoCai;
    private Integer giaBanhCai;
    private Integer giaGameCai;
    public TinhTienCoDongDTO() {

    }
    public TinhTienCoDongDTO(TinhTienCoDong tinhTienCoDong) {
        this.id = tinhTienCoDong.getId();
//        this.tienCuCoDong = tinhTienCoDong.getTienCuCoDong();
//        this.chungChiCoDong = tinhTienCoDong.getChungChiCoDong();
//        this.tienConLaiCoDong = tinhTienCoDong.getTienConLaiCoDong();
        this.ngayTinhTien = tinhTienCoDong.getNgayTinhTien();
        this.ngayKetThuc = tinhTienCoDong.getNgayKetThuc();
        this.coDong = tinhTienCoDong.getCoDong();
        this.thanhTienCoDong = tinhTienCoDong.getThanhTienCoDong();
        this.giaDoCai = tinhTienCoDong.getGiaDoCai();
        this.giaBanhCai = tinhTienCoDong.getGiaBanhCai();
        this.giaGameCai = tinhTienCoDong.getGiaGameCai();
    }
}
