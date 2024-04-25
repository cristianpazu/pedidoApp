package com.example.controller;


import com.example.PedidoApp.model.Pedido;
import com.example.PedidoApp.model.Productos;
import com.example.PedidoApp.reports.venta.ventaReport;
import com.example.PedidoApp.service.productoService.impl.ProductoServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/productos")
public class ProductoController {



    @Autowired
    private  ProductoServiceImpl productoService;

@PostMapping("/registrarProductos")
    public Productos registrarProducto(@RequestBody Productos productos){

    return productoService.registrarProducto(productos);

    }

    @GetMapping("/traerporId/{id}")
    public Productos registrarProducto(@PathVariable Long id){

        return productoService.traerProductoId(id);

    }

    @GetMapping("/traerTodo")
    public List<Productos> traerProduucto(){
        return productoService.traerTodoProducto();
    }



}
