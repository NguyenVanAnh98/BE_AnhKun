package com.example.demo.model.dto;

import com.example.demo.model.NguoiTheo;
import com.example.demo.model.TinhTienNguoiTheo;
import jakarta.persistence.*;

import java.time.LocalDate;

public class TinhTienNguoiTheoDTO {

    private Long id;
    private Double tienCuNguoiTheo;
    private Double chungChiNguoiTheo;
    private Double tienConLaiNguoiTheo;
    private LocalDate ngayTinhTien;
    private LocalDate ngayKetThuc;
    private NguoiTheo nguoiTheo;
    private Double thanhTienNguoiTheo;

    public TinhTienNguoiTheoDTO() {
    }

    public TinhTienNguoiTheoDTO(TinhTienNguoiTheo tinhTienNguoiTheo) {
       this.id = tinhTienNguoiTheo.getId();
       this.tienCuNguoiTheo = tinhTienNguoiTheo.getTienCuNguoiTheo();
       this.chungChiNguoiTheo = tinhTienNguoiTheo.getChungChiNguoiTheo();
       this.tienConLaiNguoiTheo = tinhTienNguoiTheo.getTienConLaiNguoiTheo();
       this.ngayTinhTien = tinhTienNguoiTheo.getNgayTinhTien();
       this.ngayKetThuc = tinhTienNguoiTheo.getNgayKetThuc();
       this.nguoiTheo = tinhTienNguoiTheo.getNguoiTheo();
       this.thanhTienNguoiTheo = tinhTienNguoiTheo.getThanhTienNguoiTheo();
    }
}
