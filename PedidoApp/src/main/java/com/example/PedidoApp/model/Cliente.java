package com.example.PedidoApp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCliente;


    Integer documento;

    String nombre;


    String apellido;


    String direccion;


    String correo;


    String celular;

    String estado;
@Transient
    @OneToMany(mappedBy = "clientes", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private List<Pedido> pedidos;


}
