package com.example.PedidoApp.controller.CategoriaController;

import com.example.PedidoApp.model.Categoria;
import com.example.PedidoApp.model.Productos;
import com.example.PedidoApp.service.categoriaService.impl.CategoriaServiceImpl;
import com.example.PedidoApp.service.productoService.impl.ProductoServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Categoria registrarCategoria(@RequestBody Categoria categoria){

        return categoriaService.registrarCategoria(categoria);

    }
}
