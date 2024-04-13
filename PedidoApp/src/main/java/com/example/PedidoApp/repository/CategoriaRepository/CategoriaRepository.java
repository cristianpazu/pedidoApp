package com.example.PedidoApp.repository.CategoriaRepository;

import com.example.PedidoApp.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {


//    Optional<Categoria> findByIdCategoria(Long IdCategoria);

}
