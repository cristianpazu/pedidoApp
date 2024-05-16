package com.example.PedidoApp.controller.CategoriaController;

import com.example.PedidoApp.model.Categoria;
import com.example.PedidoApp.model.Productos;
import com.example.PedidoApp.service.categoriaService.impl.CategoriaServiceImpl;
import com.example.PedidoApp.service.productoService.impl.ProductoServiceImpl;
import com.example.PedidoApp.utils.ResponseHandler;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Categoria")
public class CategoriaController {


    @Autowired
    private  CategoriaServiceImpl categoriaService;

    @PostMapping("/registrarCategoria")
    public ResponseEntity<Object> registrarCategoria(@RequestBody Categoria categoria){

        return  new ResponseHandler().generateResponse(HttpStatus.OK, categoriaService.registrarCategoria(categoria));

    }
}
