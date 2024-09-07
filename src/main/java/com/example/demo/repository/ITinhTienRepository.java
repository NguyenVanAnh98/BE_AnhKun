package com.example.demo.repository;

import com.example.demo.model.KhachHang;
import com.example.demo.model.TinhTien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITinhTienRepository extends JpaRepository<TinhTien, Long> {
    List<TinhTien> findTinhTienByKhachHang(KhachHang khachHang);
    @Query("select TinhTien from TinhTien tt where tt.khachHang.id = :khachHangId order by tt.id desc")
    TinhTien findTopByKhachHangId(@Param("khachHangId") Long id);

}
