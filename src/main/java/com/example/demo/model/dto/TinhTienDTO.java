package com.example.demo.model.dto;

import com.example.demo.model.KhachHang;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.AutoConfiguration;

import java.time.LocalDate;

@Getter
@Setter
@AutoConfiguration
@NoArgsConstructor
public class TinhTienDTO {
    private Long id;
    private LocalDate ngayDauTuan;
    private LocalDate ngayCuoiTuan;
    private Double tyGiaTuan;
    private Double thanhtienIBet;
    private Double thanhtienSBo;
    private Integer anThuaKhachHang;
    private Integer coBanhKhachHang;
    private Integer coGameKhachHang;
    private Double tongCongBanh;
    private Integer tiSoKhachHang;
    private Integer soDeKhachHang;
    private Integer tienUngKhachHang;
    private Integer tienGopTuan;
    private Double tongCongKhachHang;
    private Double tongCongCty;
    private Double comm;
}
