package com.example.service;



import com.example.model.Productos;

import java.util.List;

public interface ProductoServiceInterface {

    Productos registrarProducto(Productos productos);


    List<Productos> traerTodoProducto();


    Productos traerProductoId(Long id);




}
