package com.example.controller;


import com.example.model.Categoria;
import com.example.service.impl.CategoriaServiceImpl;
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
    private CategoriaServiceImpl categoriaService;

    @PostMapping("/registrarCategoria")
    public Categoria registrarCategoria(@RequestBody Categoria categoria){

        return categoriaService.registrarCategoria(categoria);

    }
}
