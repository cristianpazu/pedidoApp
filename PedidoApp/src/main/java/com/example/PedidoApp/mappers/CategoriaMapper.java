package com.example.PedidoApp.mappers;

import com.example.PedidoApp.model.Categoria;
import com.example.PedidoApp.model.DTO.CategoriaDTO;
import com.example.PedidoApp.model.DTO.CategoriaResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    CategoriaResponseDTO categoriaResponseDto (Categoria categoria);

    Categoria registarCategoriaRespuestaDtTO (CategoriaDTO categoriaDTO);
}
