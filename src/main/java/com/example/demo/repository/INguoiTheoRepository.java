package com.example.demo.repository;

import com.example.demo.model.NguoiTheo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface INguoiTheoRepository extends JpaRepository<NguoiTheo, Long> {
}
