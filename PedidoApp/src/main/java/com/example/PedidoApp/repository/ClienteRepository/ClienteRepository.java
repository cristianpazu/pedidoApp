package com.example.PedidoApp.repository.ClienteRepository;

import com.example.PedidoApp.model.Cliente;
import com.example.PedidoApp.model.DTO.ClienteDTO;
import com.example.PedidoApp.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findClienteByDocumento(Integer documento);
}
