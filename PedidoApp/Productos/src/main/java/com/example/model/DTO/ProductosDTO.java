package com.example.model.DTO;

import com.example.PedidoApp.model.Categoria;
import com.example.PedidoApp.model.Stock;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductosDTO {

    Long idProductos;


    String nombre;


    Double precio;


    Integer cantidad;

    double iva;

    private String fechaIngreso;

    private String fechaVencimiento;

    Set<Categoria> categorias = new HashSet<>();

    private Stock stocks;

}
