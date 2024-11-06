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
@Table(name = "chungchicodong")
public class ChungChiCoDong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer chungChiCoDong;
    private LocalDate ngayChungChi;

    @ManyToOne
    @JoinColumn(name = "tongtiencodong_id", referencedColumnName = "id")
    private TongTienCoDong tongTienCoDong;
}
