package com.example.demo.model.dto.res;

import com.example.demo.model.NguoiTheo;
import com.example.demo.model.dto.KhachHangDTO;

import java.util.List;

public class NguoiTheoDetailResponseDTO {
    private Long id;
    private String name;
    private List<KhachHangDTO> khachHangList;

    // Constructor
    public NguoiTheoDetailResponseDTO(NguoiTheo nguoiTheo, List<KhachHangDTO> khachHangList) {
        this.id = nguoiTheo.getId();
        this.name = nguoiTheo.getName();
        this.khachHangList = khachHangList;
    }

    // Getters and Setters
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