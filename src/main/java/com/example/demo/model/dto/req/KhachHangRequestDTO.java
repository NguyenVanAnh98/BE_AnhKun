package com.example.demo.model.dto.req;


import com.example.demo.model.Loai;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class KhachHangRequestDTO {
    private String maKhachHang;
    private String name;
    private Long loaiId;  // Thay vì lưu trữ đối tượng Loai trực tiếp, sử dụng ID
    private Integer giaDo;
    private Integer giaBanh;
    private Integer giaGame;
    private Double tyLe;  // Thêm trường tỷ lệ phần trăm
    private List<TheoXuKHReqDTO> theoXuKHReqDTOS;  // Thay đổi nếu cần
}

