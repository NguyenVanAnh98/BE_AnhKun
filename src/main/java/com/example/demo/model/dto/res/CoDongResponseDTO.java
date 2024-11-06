package com.example.demo.model.dto.res;

import com.example.demo.model.CoDong;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoDongResponseDTO {
    private Long id;
    private String name;
    private String tenKhachHang;


    public CoDongResponseDTO(CoDong coDong) {
        this.id = coDong.getId();
    this.name = coDong.getName();
    }
}
