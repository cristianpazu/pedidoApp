package com.example.PedidoApp.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idStock;

    Integer cantidadStock;

/*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bodega_id")
    private Bodega bodega; */

}
