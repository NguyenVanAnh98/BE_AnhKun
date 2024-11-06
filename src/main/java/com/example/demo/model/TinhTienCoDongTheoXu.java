//package com.example.demo.model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.time.LocalDate;
//
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@Table(name = "tinhTienCoDongTheoXu")
//public class TinhTienCoDongTheoXu {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private Integer giaDoCai;
//    private Integer giaBanhCai;
//    private Integer giaGameCai;
//    private LocalDate ngayTinhTien;
//    private LocalDate ngayKetThuc;
//    private Double thanhTienCoDong;
//    @ManyToOne
//    @JoinColumn(name = "coDong_id", referencedColumnName = "id")
//    private CoDong coDong;
//    private Long idKhachHang;
//
//
//}
