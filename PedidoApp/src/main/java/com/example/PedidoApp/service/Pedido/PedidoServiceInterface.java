package com.example.PedidoApp.service.Pedido;

import com.example.PedidoApp.model.Cliente;
import com.example.PedidoApp.model.Pedido;

import java.util.List;

public interface PedidoServiceInterface {

    Pedido registrarPedido(Pedido pedido );

   Pedido traerPorId(Long id);


  List<Pedido> traerTodoPedido();


}
