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
@Table(name = "tinhTienNguoiTheo")
public class TinhTienNguoiTheo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double tienCuNguoiTheo;
    private Double chungChiNguoiTheo;
    private Double tienConLaiNguoiTheo;
    private LocalDate ngayTinhTien;
    private LocalDate ngayKetThuc;
    private Double thanhTienNguoiTheo;


    @ManyToOne
    @JoinColumn(name = "nguoiTheo_id", referencedColumnName = "id")
    private NguoiTheo nguoiTheo;

}
