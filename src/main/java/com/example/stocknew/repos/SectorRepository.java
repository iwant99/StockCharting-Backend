package com.example.stocknew.repos;

import com.example.stocknew.models.Sector;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectorRepository extends JpaRepository<Sector, Long> {
    boolean existsByName(String name);
}