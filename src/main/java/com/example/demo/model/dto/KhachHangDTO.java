package com.example.demo.model.dto;

import com.example.demo.model.KhachHang;
import com.example.demo.model.Loai;
import com.example.demo.model.TinhTien;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.AutoConfiguration;

import java.util.List;

@Setter
@Getter
@AutoConfiguration
@NoArgsConstructor
public class KhachHangDTO {
    private String name;
    private Integer xuTheo;
    private Loai loai;
    private Integer giaDo;
    private Integer giaBanh;
    private Integer giaGame;
    private List<TinhTienDTO> tinhtien;

    }


    // Constructor
//    public KhachHangDTO(String name, Integer xuTheo) {
//        this.name = name;
//        this.xuTheo = xuTheo;
//    }
//
//    // Getters and Setters
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getXuTheo() {
//        return xuTheo;
//    }
//
//    public void setXuTheo(Integer xuTheo) {
//        this.xuTheo = xuTheo;
//    }


