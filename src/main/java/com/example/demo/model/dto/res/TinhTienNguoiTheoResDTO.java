package com.example.demo.model.dto.res;

import com.example.demo.model.dto.KhachHangDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TinhTienNguoiTheoResDTO {
    private Long id;
    private String name;
    private List<KhachHangDTO> khachHangList;
}
