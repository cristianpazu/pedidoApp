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
public class Pedido {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPedido;

    String fechaPedido;

    double total;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "producto_pedidos",
            joinColumns = @JoinColumn(
                    name = "producto_id"
            ), inverseJoinColumns = @JoinColumn(name = "pedido_id")


    )
    Set<Productos> productos = new HashSet<>();


    @ManyToOne
    @JoinTable(name = "pedido_cliente",
            joinColumns = @JoinColumn(
                    name = "pedido_id"
            ), inverseJoinColumns = @JoinColumn(name = "cliente_id")


    )
   private Cliente clientes;

    @ManyToOne
    @JoinTable(name = "pedido_usuario",
            joinColumns = @JoinColumn(
                    name = "pedido_id"
            ), inverseJoinColumns = @JoinColumn(name = "usuario_id")


    )
    private Usuario usuario;
}
