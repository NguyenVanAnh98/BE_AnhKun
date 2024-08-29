package com.example.demo.model.dto.res;

import com.example.demo.model.NguoiTheo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NguoiTheoResponseDTO {
    private Long id;
    private String name;
    private String tenKhachHang;

    public NguoiTheoResponseDTO(NguoiTheo nguoiTheo) {
        this.id = nguoiTheo.getId();
        this.name = nguoiTheo.getName();

    }
}
