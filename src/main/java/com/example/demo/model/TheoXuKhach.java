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
@Table(name = "theoxukhach")
public class TheoXuKhach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer xuTheo;  // Xu theo



    @ManyToOne
    @JoinColumn(name = "khachhang_id")
    private KhachHang khachHang;  // Liên kết với KhachHang
    @ManyToOne
    @JoinColumn(name = "nguoitheo_id")
    private NguoiTheo nguoiTheo;  // Liên kết với NguoiTheo
    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }
}
