package com.example.demo.repository;

import com.example.demo.model.TinhTien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITinhTienRepository extends JpaRepository<TinhTien, Long> {
}
