package com.example.demo.repository;

import com.example.demo.model.NguoiTheo;
import com.example.demo.model.TongTienNguoiTheo;
import com.example.demo.model.dto.TongTienNguoiTheoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
@Repository
public interface ITongTienNguoiTheoRepository extends JpaRepository<TongTienNguoiTheo, Long> {
    @Query("select new com.example.demo.model.dto.TongTienNguoiTheoDTO(t)" +
    "from TongTienNguoiTheo t where t.nguoiTheo.id = :nguoitheoID and t.id = (select max(t2.id) from TongTienNguoiTheo t2 where t2.nguoiTheo.id= :nguoitheoID)")
    TongTienNguoiTheoDTO findTopByIdNguoiTheo(@Param("nguoitheoID") Long id);
    TongTienNguoiTheo findTongTienByNguoiTheoAndNgayTinhTien(NguoiTheo nguoiTheo, LocalDate ngayTinhTien);

}
