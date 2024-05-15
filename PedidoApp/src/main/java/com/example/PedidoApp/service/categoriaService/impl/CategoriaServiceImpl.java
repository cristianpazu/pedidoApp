package com.example.PedidoApp.service.categoriaService.impl;

import com.example.PedidoApp.Exceptions.MensajeErrorEnum;
import com.example.PedidoApp.Exceptions.RequestException;
import com.example.PedidoApp.mappers.CategoriaMapper;
import com.example.PedidoApp.model.Categoria;
import com.example.PedidoApp.model.DTO.CategoriaDTO;
import com.example.PedidoApp.model.DTO.CategoriaResponseDTO;
import com.example.PedidoApp.model.Productos;
import com.example.PedidoApp.repository.CategoriaRepository.CategoriaRepository;
import com.example.PedidoApp.service.categoriaService.CategoriaServiceInterface;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@AllArgsConstructor
public class CategoriaServiceImpl implements CategoriaServiceInterface {

    private final CategoriaMapper categoriaMapper;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public CategoriaResponseDTO registrarCategoria(CategoriaDTO categoriaDTO) {



        try {
            Categoria registrarCategoria = categoriaMapper.registarCategoriaRespuestaDtTO(categoriaDTO);
            registrarCategoria = categoriaRepository.save(registrarCategoria);

            return categoriaMapper.categoriaResponseDto(registrarCategoria);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Categoria> traerTodoCategoria() {
        List<Categoria> categoriaList = categoriaRepository.findAll();

        try{
            return categoriaList;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Categoria traerCategoriaId(Long id) {
        return null;
    }
}
