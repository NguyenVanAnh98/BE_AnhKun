package com.example.demo.repository;

import com.example.demo.model.KhachHang;
import com.example.demo.model.TinhTien;
import com.example.demo.model.dto.KhachHangDTO;
import com.example.demo.model.dto.TinhTienDTO;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITinhTienRepository extends JpaRepository<TinhTien, Long> {
    List<TinhTien> findTinhTienByKhachHang(KhachHang khachHang);
    @Query("select new com.example.demo.model.dto.TinhTienDTO(t) " + // Thêm t.khachHang
            "from TinhTien t where t.khachHang.id = :khachhangID and t.id = (select max(t2.id) from TinhTien t2 where t2.khachHang.id = :khachhangID)")
    TinhTienDTO findTopDTOByKhachHangId(@Param("khachhangID") Long id);

    List<TinhTien> findAllByNgayDauTuanAndKhachHang(LocalDate date, KhachHang khachHang);
}
