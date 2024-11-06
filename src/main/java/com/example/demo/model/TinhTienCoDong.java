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
@Table(name = "tinhTienCoDong")
public class TinhTienCoDong {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
//private Double tienCuCoDong;
//private Integer chungChiCoDong;
//private Double tienConLaiCoDong;
private LocalDate ngayTinhTien;
private LocalDate ngayKetThuc;
private Double thanhTienCoDong;
private Integer giaDoCai;
private Integer giaBanhCai;
private Integer giaGameCai;
//private Double tongTienCoDong;

@ManyToOne
@JoinColumn(name = "coDong_id", referencedColumnName = "id")
private CoDong coDong;
private Long idKhachHang;
}
