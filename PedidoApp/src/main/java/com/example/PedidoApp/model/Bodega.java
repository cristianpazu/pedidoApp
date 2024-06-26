package com.example.PedidoApp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
public class Bodega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idBodega;


    String nombre;

    private String fechaCreacionBodega;

    @ManyToMany(mappedBy = "Bodega")
    private Set<Productos> productosSet;

}
