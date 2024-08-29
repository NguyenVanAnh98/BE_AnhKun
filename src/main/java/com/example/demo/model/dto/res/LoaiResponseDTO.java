package com.example.demo.model.dto.res;

import com.example.demo.model.Loai;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoaiResponseDTO {
    private Long id;
    private String tenLoai;
    private Double phanTram;

    public LoaiResponseDTO(Loai loai) {
        if (loai != null) {
            this.id = loai.getId();
            this.tenLoai = loai.getTenLoai();
            this.phanTram = loai.getPhanTram();
        } else {
            this.id = null;
            this.tenLoai = "Unknown";
            this.phanTram = 0.0; // Hoặc giá trị mặc định phù hợp
        }
    }
}
