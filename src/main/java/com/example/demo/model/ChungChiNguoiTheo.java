package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "chungchinguoitheo")
public class ChungChiNguoiTheo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer chungChiNguoiTheo;
    private LocalDate ngayChungChi;

    @ManyToOne
    @JoinColumn(name = "tongtiennguoitheo_id", referencedColumnName = "id")
    private TongTienNguoiTheo tongTienNguoiTheo;

}
