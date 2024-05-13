package com.example.PedidoApp.repository.StockRepository;

import com.example.PedidoApp.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
