package com.example.PedidoApp.service.categoriaService.impl;

import com.example.PedidoApp.model.Categoria;
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
public class CategoriaServiceImpl implements CategoriaServiceInterface {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria registrarCategoria(Categoria categoria) {


      /*  if (categoriaRepository.findByIdCategoria(categoria.getIdCategoria()).isPresent()) {
            throw new RuntimeException("Categoria ya registrado");
        } */

        try {

            return categoriaRepository.save(categoria);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Categoria> traerTodoCategoria() {
        return null;
    }

    @Override
    public Categoria traerCategoriaId(Long id) {
        return null;
    }
}
