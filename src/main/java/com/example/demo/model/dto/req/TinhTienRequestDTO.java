package com.example.demo.model.dto.req;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TinhTienRequestDTO {

    private LocalDate ngayDauTuan;
    private LocalDate ngayCuoiTuan;
    private Double tiGiaTuan;
    private Integer anThuaKhachHang;
    private Integer coBanhKhachHang;
    private Integer coGameKhachHang;
    private Integer tiSoKhachHang;
    private Integer soDeKhachHang;
    private Integer tienUngKhachHang;
    private Integer tienGopTuan;
    private Long nguoiTheoId;
    private Long khachHangId;
    private Long loaiId;
    private Double comm;

}
