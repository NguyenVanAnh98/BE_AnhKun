package com.example.demo.repository;

import com.example.demo.model.KhachHang;
import com.example.demo.model.dto.res.KhachHangResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IKhachHangRepository extends JpaRepository<KhachHang, Long> {
    @Query("SELECT new com.example.demo.model.dto.res.KhachHangResponseDTO(kh) " +
            "FROM KhachHang kh " +
            "LEFT JOIN kh.theoXuKhachs txk " +
//            "LEFT JOIN kh.nguoiTheos nt " +
            "LEFT JOIN kh.loai loai " +
            "WHERE kh.id = :khachHangId")
    List<KhachHangResponseDTO> findKhachHangDetails(@Param("khachHangId") Long khachHangId);
    List<KhachHang> findByLoai_TenLoai(String tenLoai);
}
