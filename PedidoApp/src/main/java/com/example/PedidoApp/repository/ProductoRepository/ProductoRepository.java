package com.example.PedidoApp.repository.ProductoRepository;

import com.example.PedidoApp.model.Categoria;
import com.example.PedidoApp.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProductoRepository extends JpaRepository<Productos, Integer> {

    Optional<Productos> findByIdProductos(Integer idProductos);

}
