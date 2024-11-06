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
@Table(name = "tongTienNguoiTheo")
public class TongTienNguoiTheo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate ngayTinhTien;
    private LocalDate ngayKetThuc;
    private Double tienCuNguoiTheo;
    private Integer chungChiNguoiTheo;
    private Double tienConLaiNguoiTheo;
    private Double tongTienNguoiTheo;

    @ManyToOne
    @JoinColumn(name = "nguoiTheo_id", referencedColumnName = "id")
    private NguoiTheo nguoiTheo;
}
