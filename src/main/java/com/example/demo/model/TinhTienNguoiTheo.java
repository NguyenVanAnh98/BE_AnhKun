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
@Table(name = "tinhTienNguoiTheo")
public class TinhTienNguoiTheo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "nguoiTheo_id", referencedColumnName = "id")
    private NguoiTheo nguoiTheo;



    @ManyToOne
    @JoinColumn(name = "tinhTien_id", referencedColumnName = "id")
    private TinhTien tinhTien;
    private Integer xuTheo;
}
