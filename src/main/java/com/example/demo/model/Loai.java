package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "loai")
public class Loai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tenLoai;  // Tên loại (IBET, SBO)

    // Nếu cần tỷ lệ phần trăm, thêm thuộc tính này
    private Double phanTram;


}