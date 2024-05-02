package com.example.PedidoApp.repository.BodegaRepository;

import com.example.PedidoApp.model.Bodega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodegaRepository extends JpaRepository<Bodega, Long> {
}
