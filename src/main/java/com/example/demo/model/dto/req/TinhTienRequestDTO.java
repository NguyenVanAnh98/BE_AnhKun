package com.example.demo.model.dto.req;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.AutoConfiguration;

import java.time.LocalDate;

@Getter
@Setter
@AutoConfiguration
@NoArgsConstructor
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
