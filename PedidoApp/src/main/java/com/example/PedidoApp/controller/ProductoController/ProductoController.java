package com.example.PedidoApp.controller.ProductoController;


import com.example.PedidoApp.model.Pedido;
import com.example.PedidoApp.model.Productos;
import com.example.PedidoApp.reports.venta.ventaReport;
import com.example.PedidoApp.service.productoService.impl.ProductoServiceImpl;
import com.example.PedidoApp.utils.ResponseHandler;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/productos")
public class ProductoController {



    @Autowired
    private  ProductoServiceImpl productoService;

@PostMapping("/registrarProductos")
    public ResponseEntity<Object> registrarProducto(@RequestBody Productos productos){

    return new ResponseHandler().generateResponse(HttpStatus.OK, productoService.registrarProducto(productos));

    }

    @GetMapping("/traerporId/{id}")
    public ResponseEntity<Object> registrarProducto(@PathVariable Long id){

        return new ResponseHandler().generateResponse(HttpStatus.OK, productoService.traerProductoId(id));

    }

    @GetMapping("/traerTodo")
    public ResponseEntity<Object> traerProduucto(){
        return new ResponseHandler().generateResponse(HttpStatus.OK, productoService.traerTodoProducto());
    }



}
