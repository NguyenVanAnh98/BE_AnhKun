package com.example.demo.model.dto.res;

import com.example.demo.model.CoDong;
import com.example.demo.model.dto.KhachHangDTO;

import java.util.List;

public class CoDongDetailResponseDTO {
    private Long id;
    private String name;
    private List<KhachHangDTO> khachHangList;
    public CoDongDetailResponseDTO(CoDong coDong, List<KhachHangDTO> khachHangList) {
        this.id = coDong.getId();
        this.name = coDong.getName();
        this.khachHangList = khachHangList;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<KhachHangDTO> getKhachHangList() {
        return khachHangList;
    }
    public void setKhachHangList(List<KhachHangDTO> khachHangList) {
        this.khachHangList = khachHangList;
    }
}
