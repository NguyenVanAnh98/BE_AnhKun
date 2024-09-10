package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private Integer chungChi;
    private Double conLai;
    private Double tienCu;


    private Double comm;


    @ManyToOne
    @JoinColumn(name = "khachhang_id", referencedColumnName = "id")
    private KhachHang khachHang;  // Cách tính tiền có một khách hàng



}
