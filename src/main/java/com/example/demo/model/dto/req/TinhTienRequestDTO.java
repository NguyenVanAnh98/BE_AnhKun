package com.example.demo.model.dto.req;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TinhTienRequestDTO {
    private Long id;
    private Integer anThua;
    private Integer coBanh;
    private Integer coGame;
    private Integer tiSo;
    private Integer soDe;
    private Integer tienUng;
    private Integer tienGop;
    private Long idKH;
    private Double comm;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer tyGiaTuan;

}
