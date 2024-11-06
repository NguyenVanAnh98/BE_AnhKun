package com.example.demo.model.dto;

import com.example.demo.model.TongTienCoDong;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TongTienCoDongDTO {
    private Long id;
    private LocalDate ngayTinhTien;
    private LocalDate ngayKetThuc;
    private Double tienCuCoDong;
    private Integer chungChiCoDong;
    private Double tienConLaiCoDong;
    private Double tongTienCoDong;
    private Long idCoDong;

    public TongTienCoDongDTO() {
}

    public TongTienCoDongDTO(TongTienCoDong tongTienCoDong) {
        this.id = tongTienCoDong.getId();
        this.ngayTinhTien = tongTienCoDong.getNgayTinhTien();
        this.ngayKetThuc = tongTienCoDong.getNgayKetThuc();
        this.tienCuCoDong = tongTienCoDong.getTienCuCoDong();
        this.chungChiCoDong = tongTienCoDong.getChungChiCoDong();
        this.tienConLaiCoDong = tongTienCoDong.getTienConLaiCoDong();
        this.tongTienCoDong = tongTienCoDong.getTongTienCoDong();
        this.idCoDong = tongTienCoDong.getCoDong().getId();
    }
}
