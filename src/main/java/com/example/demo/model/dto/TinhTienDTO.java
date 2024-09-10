package com.example.demo.model.dto;

import com.example.demo.model.KhachHang;
import com.example.demo.model.TinhTien;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.AutoConfiguration;

import java.time.LocalDate;

@Getter
@Setter
public class TinhTienDTO {
    private Long id;
    private LocalDate ngayDauTuan;
    private LocalDate ngayCuoiTuan;
    private Double tyGiaTuan;
    private Double thanhtienIBet;
    private Double thanhtienSBo;
    private Integer anThuaKhachHang;
    private Integer coBanhKhachHang;
    private Integer coGameKhachHang;
    private Double tongCongBanh;
    private Integer tiSoKhachHang;
    private Integer soDeKhachHang;
    private Integer tienUngKhachHang;
    private Integer tienGopTuan;
    private Double tongCongKhachHang;
    private Double tongCongCty;
    private Integer chungChi;
    private Double conLai;
    private Double tienCu;
    private Double comm;
    private KhachHang khachHang;
    public TinhTienDTO(){};
    public TinhTienDTO(TinhTien tinhTien) {  // Sửa constructor để bao gồm KhachHang
        this.id = tinhTien.getId();
        this.ngayDauTuan = tinhTien.getNgayDauTuan() ;
        this.ngayCuoiTuan = tinhTien.getNgayCuoiTuan();
        this.tyGiaTuan = tinhTien.getTyGiaTuan();
        this.thanhtienIBet = tinhTien.getThanhtienIBet();
        this.thanhtienSBo = tinhTien.getThanhtienSBo();
        this.anThuaKhachHang = tinhTien.getAnThuaKhachHang();
        this.coBanhKhachHang = tinhTien.getCoBanhKhachHang();
        this.coGameKhachHang = tinhTien.getCoGameKhachHang();
        this.tongCongBanh = tinhTien.getTongCongBanh()  ;
        this.tiSoKhachHang = tinhTien.getTiSoKhachHang();
        this.soDeKhachHang = tinhTien.getSoDeKhachHang();
        this.tienUngKhachHang = tinhTien.getTienUngKhachHang();
        this.tienGopTuan = tinhTien.getTienGopTuan();
        this.tongCongKhachHang = tinhTien.getTongCongKhachHang();
        this.tongCongCty = tinhTien.getTongCongCty();
        this.chungChi = tinhTien.getChungChi();
        this.conLai = tinhTien.getConLai();
        this.comm = tinhTien.getComm();
        this.tienCu = tinhTien.getTienCu();
        this.khachHang = tinhTien.getKhachHang();  // Lưu đối tượng KhachHang
    }
}
