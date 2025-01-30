package com.example.PedidoApp.model.DTO;

import com.example.PedidoApp.model.Bodega;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BodegaDTO {

    Integer idBodega;


    String nombre;

    String fechaCreacionBodega;

}
