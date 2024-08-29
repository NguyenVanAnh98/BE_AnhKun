package com.example.demo.model.dto.res;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TinhTienResponseDTO {

    private Long id;
    private LocalDate ngayDauTuan;
    private LocalDate ngayCuoiTuan;
    private Double tiGiaTuan;
    private Double thanhtienIBet;
    private Double thanhtienSBo;
    private Double thanhtienAnThua;
    private Double thanhtienCoBanh;
    private Double thanhtienCoGame;
    private Double tongCongBanh;
    private Double tongCongKhachHang;
    private Double tongCongCty;
    private Double thanhtienNguoiTheo;

    private String nguoiTheoName;
    private String khachHangName;
    private String loaiName;


}
