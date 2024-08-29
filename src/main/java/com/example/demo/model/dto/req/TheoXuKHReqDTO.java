package com.example.demo.model.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TheoXuKHReqDTO {

    private Integer xuTheo;
    private Long idNguoiTheo;
    private String tenKhachTheo;
}
