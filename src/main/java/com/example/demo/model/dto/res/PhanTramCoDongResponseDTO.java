package com.example.demo.model.dto.res;

import com.example.demo.model.CoDong;
import com.example.demo.model.PhanTramCoDong;
import com.example.demo.model.TinhTienCoDong;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PhanTramCoDongResponseDTO {
    private Long id;
    private Long idCoDong;
    private Long idKhachHang;
    private Integer phanTramTheo;
    private String tenCoDong;

    public PhanTramCoDongResponseDTO(PhanTramCoDong phanTramCoDong) {
        this.id = phanTramCoDong.getId();
        this.idCoDong = phanTramCoDong.getCoDong().getId();
        this.idKhachHang = phanTramCoDong.getKhachHang() != null ? phanTramCoDong.getKhachHang().getId() : null;
        this.phanTramTheo = phanTramCoDong.getPhanTramTheo();
        this.tenCoDong = phanTramCoDong.getCoDong().getName();
    }

    @Getter
    @Setter
    public static class TinhTienCoDongDTO {
        private Long id;
        private Double tienCuCoDong;
        private Integer chungChiCoDong;
        private Double tienConLaiCoDong;
        private LocalDate ngayTinhTien;
        private LocalDate ngayKetThuc;
        private CoDong coDong;
        private Double thanhTienCoDong;


        public TinhTienCoDongDTO() {

        }

        public TinhTienCoDongDTO(TinhTienCoDong tinhTienCoDong) {
            this.id = tinhTienCoDong.getId();
//            this.tienCuCoDong = tinhTienCoDong.getTienCuCoDong();
//            this.chungChiCoDong = tinhTienCoDong.getChungChiCoDong();
//            this.tienConLaiCoDong = tinhTienCoDong.getTienConLaiCoDong();
            this.ngayTinhTien = tinhTienCoDong.getNgayTinhTien();
            this.ngayKetThuc = tinhTienCoDong.getNgayKetThuc();
            this.coDong = tinhTienCoDong.getCoDong();
            this.thanhTienCoDong = tinhTienCoDong.getThanhTienCoDong();
        }
    }
}
