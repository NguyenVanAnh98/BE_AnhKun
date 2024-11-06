package com.example.demo.repository;

import com.example.demo.model.NguoiTheo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface INguoiTheoRepository extends JpaRepository<NguoiTheo, Long> {
}
