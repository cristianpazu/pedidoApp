package com.example.service;


import com.example.model.Categoria;
import java.util.List;

public interface CategoriaServiceInterface {

    Categoria registrarCategoria(Categoria categoria);


    List<Categoria> traerTodoCategoria();


    Categoria traerCategoriaId(Long id);


}
