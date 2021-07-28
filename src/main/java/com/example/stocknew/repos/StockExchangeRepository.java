package com.example.stocknew.repos;

import com.example.stocknew.models.StockExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockExchangeRepository extends JpaRepository<StockExchange, Long> {
    boolean existsByName(String name);
}