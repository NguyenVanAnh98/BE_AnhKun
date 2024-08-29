//package com.example.demo.model.dto.res;
//
//import com.example.demo.model.KhachHang;
//import com.example.demo.model.Loai;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Getter
//@Setter
//public class KhachHangResponseDTO {
//    private Long id;
//    private String maKhachHang;
//    private String name;
//    private LoaiResponseDTO loai;
//    private Integer giaDo;
//    private Integer giaBanh;
//    private Integer giaGame;
//    private Double tyLe;
//    private List<NguoiTheoResponseDTO> nguoiTheos;
//    private List<TheoXuKhachResponseDTO> theoXuKhachs;
//
//    public KhachHangResponseDTO(KhachHang khachHang) {
//        this.id = khachHang.getId();
//        this.maKhachHang = khachHang.getMaKhachHang();
//        this.name = khachHang.getName();
//        this.loai = new LoaiResponseDTO(khachHang.getLoai());
//        this.giaDo = khachHang.getGiaDo();
//        this.giaBanh = khachHang.getGiaBanh();
//        this.giaGame = khachHang.getGiaGame();
//        this.tyLe = khachHang.getTyLe();
////        this.nguoiTheos = khachHang.getNguoiTheos().stream()
////                .map(NguoiTheoResponseDTO::new)
////                .collect(Collectors.toList());
//        this.theoXuKhachs = khachHang.getTheoXuKhachs().stream()
//                .map(TheoXuKhachResponseDTO::new)
//                .collect(Collectors.toList());
//    }
//}
//
package com.example.demo.model.dto.res;

import com.example.demo.model.KhachHang;
import com.example.demo.model.Loai;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class KhachHangResponseDTO {
    private Long id;
    private String maKhachHang;
    private String name;
    private LoaiResponseDTO loai;
    private Integer giaDo;
    private Integer giaBanh;
    private Integer giaGame;
    private Double tyLe;
    private List<NguoiTheoResponseDTO> nguoiTheos;
    private List<TheoXuKhachResponseDTO> theoXuKhachs;

    public KhachHangResponseDTO(KhachHang khachHang) {
        this.id = khachHang.getId();
        this.maKhachHang = khachHang.getMaKhachHang();
        this.name = khachHang.getName();
        this.loai = (khachHang.getLoai() != null) ? new LoaiResponseDTO(khachHang.getLoai()) : null;
        this.giaDo = khachHang.getGiaDo();
        this.giaBanh = khachHang.getGiaBanh();
        this.giaGame = khachHang.getGiaGame();
//        this.nguoiTheos = khachHang.getNguoiTheos() != null ?
//                khachHang.getNguoiTheos().stream()
//                        .map(NguoiTheoResponseDTO::new)
//                        .collect(Collectors.toList()) :
//                null;
        this.theoXuKhachs = khachHang.getTheoXuKhachs() != null ?
                khachHang.getTheoXuKhachs().stream()
                        .map(TheoXuKhachResponseDTO::new)
                        .collect(Collectors.toList()) :
                null;
    }
}

