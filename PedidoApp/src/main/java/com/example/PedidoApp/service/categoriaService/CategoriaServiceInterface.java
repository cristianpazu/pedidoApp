package com.example.PedidoApp.service.categoriaService;

import com.example.PedidoApp.model.Categoria;
import com.example.PedidoApp.model.DTO.CategoriaDTO;
import com.example.PedidoApp.model.DTO.CategoriaResponseDTO;
import com.example.PedidoApp.model.Productos;

import java.util.List;

public interface CategoriaServiceInterface {

    CategoriaResponseDTO registrarCategoria(CategoriaDTO categoriaDTO);


    List<Categoria> traerTodoCategoria();


    Categoria traerCategoriaId(Long id);


}
