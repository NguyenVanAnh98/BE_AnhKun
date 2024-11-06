package com.example.demo.repository;

import com.example.demo.model.CoDong;
import com.example.demo.model.NguoiTheo;
import com.example.demo.model.TinhTienCoDong;
import com.example.demo.model.dto.TinhTienCoDongDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITinhTienCoDongRepository extends JpaRepository <TinhTienCoDong, Long> {
    @Query("select  new com.example.demo.model.dto.TinhTienCoDongDTO(t)" +
    "from TinhTienCoDong  t where t.idKhachHang = :khachhangID and t.id = (select max(t2.id) from TinhTienCoDong t2 where t2.idKhachHang= :khachhangID)")
    TinhTienCoDongDTO findTopByIdKhachHang(@Param("khachhangID") Long id);
    List<TinhTienCoDong>findAllByCoDongAndNgayTinhTien(CoDong coDong, LocalDate ngayTinhTien);
}
