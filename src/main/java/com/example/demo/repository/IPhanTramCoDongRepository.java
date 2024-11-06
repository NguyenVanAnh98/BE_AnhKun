package com.example.demo.repository;

import com.example.demo.model.CoDong;
import com.example.demo.model.PhanTramCoDong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface IPhanTramCoDongRepository  extends JpaRepository<PhanTramCoDong, Long> {
    List <PhanTramCoDong> findAllByCoDong(Optional<CoDong> coDong );
}
