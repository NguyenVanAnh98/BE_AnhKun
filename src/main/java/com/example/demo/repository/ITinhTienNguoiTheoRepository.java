package com.example.demo.repository;

import com.example.demo.model.NguoiTheo;
import com.example.demo.model.TinhTienNguoiTheo;
import com.example.demo.model.TongTienNguoiTheo;
import com.example.demo.model.dto.TinhTienDTO;
import com.example.demo.model.dto.TinhTienNguoiTheoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface ITinhTienNguoiTheoRepository extends JpaRepository<TinhTienNguoiTheo, Long> {
    @Query("select new com.example.demo.model.dto.TinhTienNguoiTheoDTO(t) " + // Thêm t.khachHang
            "from TinhTienNguoiTheo t where t.idKhachHang = :khachhangID and t.id = (select max(t2.id) from TinhTienNguoiTheo t2 where t2.idKhachHang= :khachhangID)")
    TinhTienNguoiTheoDTO findTopByIdKhachHang(@Param("khachhangID") Long id);
    List<TinhTienNguoiTheo>findAllByNguoiTheoAndNgayTinhTien(NguoiTheo nguoiTheo, LocalDate ngayTinhTien);
}
