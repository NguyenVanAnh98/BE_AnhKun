package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "khachhang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String maKhachHang;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "loai_id", referencedColumnName = "id")
    private Loai loai;

    @OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL)
    private List<TinhTien> tinhTiens;



    private Integer giaDo;
    private Integer giaBanh;
    private Integer giaGame;




    @OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TheoXuKhach> theoXuKhachs;




}
