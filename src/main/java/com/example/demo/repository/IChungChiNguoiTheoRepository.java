package com.example.demo.repository;

import com.example.demo.model.ChungChiNguoiTheo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IChungChiNguoiTheoRepository extends JpaRepository<ChungChiNguoiTheo, Long> {
    List<ChungChiNguoiTheo> findByTongTienNguoiTheo_Id(Long nguoiTheoId);
}
