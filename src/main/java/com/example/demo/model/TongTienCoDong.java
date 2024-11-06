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
@Table(name = "tongTienCoDong")
public class TongTienCoDong {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate ngayTinhTien;
    private LocalDate ngayKetThuc;
    private Double tienCuCoDong;
    private Integer chungChiCoDong;
    private Double tienConLaiCoDong;
    private Double tongTienCoDong;

    @ManyToOne
    @JoinColumn(name = "coDong_id", referencedColumnName = "id")
    private CoDong coDong;
}
