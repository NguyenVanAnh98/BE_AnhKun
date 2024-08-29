package com.example.demo.model.dto.res;

import com.example.demo.model.TheoXuKhach;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TheoXuKhachResponseDTO {
    private Long id;
    private Long idKhachTheo;
    private Long idKhachHang;
    private Integer xuTheo;
    private String tenKhachTheo;

    public TheoXuKhachResponseDTO(TheoXuKhach theoXuKhach) {
        this.id = theoXuKhach.getId();
        this.idKhachTheo = theoXuKhach.getNguoiTheo().getId();
        this.idKhachHang = theoXuKhach.getKhachHang() != null ? theoXuKhach.getKhachHang().getId() : null;
        this.xuTheo = theoXuKhach.getXuTheo();
        this.tenKhachTheo = theoXuKhach.getNguoiTheo().getName();
    }
}