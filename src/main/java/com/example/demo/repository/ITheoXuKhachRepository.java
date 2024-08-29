package com.example.demo.repository;

import com.example.demo.model.NguoiTheo;
import com.example.demo.model.TheoXuKhach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ITheoXuKhachRepository extends JpaRepository<TheoXuKhach, Long> {
    List<TheoXuKhach> findAllByNguoiTheo(Optional<NguoiTheo> nguoiTheo );

}
