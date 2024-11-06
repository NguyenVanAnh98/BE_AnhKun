package com.example.demo.repository;

import com.example.demo.model.CoDong;
import com.example.demo.model.TongTienCoDong;
import com.example.demo.model.dto.TinhTienCoDongDTO;
import com.example.demo.model.dto.TongTienCoDongDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
@Repository
public interface ITongTienCoDongRepository extends JpaRepository<TongTienCoDong, Long> {
    @Query("select new com.example.demo.model.dto.TongTienCoDongDTO(t)" +
    "from TongTienCoDong t where t.coDong.id = :codongID and t.id = (select max(t2.id) from TongTienCoDong t2 where t2.coDong.id= :codongID)")
    TongTienCoDongDTO findTopByIdCoDong(@Param("codongID") Long id);
    TongTienCoDong findTongTienByCoDongAndNgayTinhTien(CoDong coDong, LocalDate ngayTinhTien);
}
