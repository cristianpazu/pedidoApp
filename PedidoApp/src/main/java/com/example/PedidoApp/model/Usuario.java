package com.example.PedidoApp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idUsuario;


    Integer documento;

    String nombre;


    String apellido;


    String direccion;


    String correo;


    String celular;

    String estado;

    @Transient
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pedido> pedidos;

    /*
    @Transient
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_cliente",
            joinColumns = @JoinColumn(
                    name = "usuario_id"
            ), inverseJoinColumns = @JoinColumn(name = "cliente_id")


    )
    Set<Cliente> clientes = new HashSet<>();

    @Transient
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_pedidos",
            joinColumns = @JoinColumn(
                    name = "usuario_id"
            ), inverseJoinColumns = @JoinColumn(name = "pedidos_id")


    )
    Set<Pedido> pedidos = new HashSet<>(); */

}
