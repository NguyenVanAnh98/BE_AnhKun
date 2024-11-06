package com.example.demo.model.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhanTramCoDongReqDTO {
    private Integer phanTramTheo;
    private Long idCoDong;
    private  String tenCoDong;
}
