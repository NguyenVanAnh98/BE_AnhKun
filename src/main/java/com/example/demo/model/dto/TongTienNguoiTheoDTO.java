package com.example.demo.model.dto;

import com.example.demo.model.TongTienNguoiTheo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TongTienNguoiTheoDTO {
    private Long id;
    private LocalDate ngayTinhTien;
    private LocalDate ngayKetThuc;
    private Double tienCuNguoiTheo;
    private Integer chungChiNguoiTheo;
    private Double tienConLaiNguoiTheo;
    private Double tongTienNguoiTheo;
    private Long idNguoiTheo;

    public TongTienNguoiTheoDTO() {
    }

    public TongTienNguoiTheoDTO(TongTienNguoiTheo tongTienNguoiTheo) {
        this.id = tongTienNguoiTheo.getId();
        this.ngayTinhTien = tongTienNguoiTheo.getNgayTinhTien();
        this.ngayKetThuc = tongTienNguoiTheo.getNgayKetThuc();
        this.tienCuNguoiTheo = tongTienNguoiTheo.getTienCuNguoiTheo();
        this.chungChiNguoiTheo = tongTienNguoiTheo.getChungChiNguoiTheo();
        this.tienConLaiNguoiTheo = tongTienNguoiTheo.getTienConLaiNguoiTheo();
        this.tongTienNguoiTheo = tongTienNguoiTheo.getTongTienNguoiTheo();
        this.idNguoiTheo = tongTienNguoiTheo.getNguoiTheo().getId();
    }
}
