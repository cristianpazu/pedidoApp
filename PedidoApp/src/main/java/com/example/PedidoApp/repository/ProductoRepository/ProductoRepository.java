package com.example.PedidoApp.repository.ProductoRepository;

import com.example.PedidoApp.model.Categoria;
import com.example.PedidoApp.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProductoRepository extends JpaRepository<Productos, Integer> {

    Optional<Productos> findByIdProductos(Integer idProductos);



    @Query(value = "SELECT pr FROM Productos pr WHERE  :fechaActual > pr.fechaVencimiento ")
    Productos findByFechaVencimiento(@Param("fechaActual") String fechaActual);


}
