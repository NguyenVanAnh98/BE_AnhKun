package com.example.demo.model.dto;

public class KhachHangDTO {
    private String name;
    private Integer xuTheo;

    // Constructor
    public KhachHangDTO(String name, Integer xuTheo) {
        this.name = name;
        this.xuTheo = xuTheo;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getXuTheo() {
        return xuTheo;
    }

    public void setXuTheo(Integer xuTheo) {
        this.xuTheo = xuTheo;
    }
}

