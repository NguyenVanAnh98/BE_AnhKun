package com.example.demo.repository;

import com.example.demo.model.ChungChiCoDong;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IChungChiCoDongRepository extends JpaRepository<ChungChiCoDong, Long> {
 List<ChungChiCoDong> findByTongTienCoDong_Id(Long nguoiTheoId);
}
