package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tinhtien")
public class TinhTien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate ngayDauTuan;
    private LocalDate ngayCuoiTuan;

    private Double tiGiaTuan;
    private Double thanhtienIBet;
    private Double thanhtienSBo;

    private Integer anThuaKhachHang;
    private Double thanhtienAnThua;

    private Integer coBanhKhachHang;
    private Double thanhtienCoBanh;

    private Integer coGameKhachHang;
    private Double thanhtienCoGame;

    private Double tongCongBanh;
    private Integer tiSoKhachHang;
    private Integer soDeKhachHang;
    private Integer tienUngKhachHang;
    private Integer tienGopTuan;
    private Double tongCongKhachHang;
    private Double tongCongCty;
    private Double thanhtienNguoiTheo;

    private Double comm;
    @ManyToOne
    @JoinColumn(name = "nguoi_theo_id", referencedColumnName = "id")
    private NguoiTheo nguoiTheo;  // NguoiTheo liên quan

    @ManyToOne
    @JoinColumn(name = "khachhang_id", referencedColumnName = "id")
    private KhachHang khachHang;  // Cách tính tiền có một khách hàng
    @ManyToOne
    @JoinColumn(name = "loai_id", referencedColumnName = "id")
    private Loai loai;  // Tham chiếu đến loại IBET


}
