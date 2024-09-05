package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "phamtramcodong")
public class PhanTramCoDong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer phanTramTheo;  // phần trăm theo
    @ManyToOne
    @JoinColumn(name = "khachhang_id")
    private KhachHang khachHang;
}
