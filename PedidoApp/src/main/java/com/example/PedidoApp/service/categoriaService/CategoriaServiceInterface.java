package com.example.PedidoApp.service.categoriaService;

import com.example.PedidoApp.model.Categoria;
import com.example.PedidoApp.model.Productos;

import java.util.List;

public interface CategoriaServiceInterface {

    Categoria registrarCategoria(Categoria categoria);


    List<Categoria> traerTodoCategoria();


    Categoria traerCategoriaId(Long id);


}
