package com.example.PedidoApp.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idProductos;


    String nombre;


    Double precio;


    Integer cantidad;

    double iva;





    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "producto_categoria",
            joinColumns = @JoinColumn(
                    name = "producto_id"
            ), inverseJoinColumns = @JoinColumn(name = "categoria_id")


    )
    Set<Categoria> categorias = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stock_id")
    private Stock stocks;
}
