package com.example.PedidoApp.service.Pedido;

import com.example.PedidoApp.model.Cliente;
import com.example.PedidoApp.model.Pedido;

public interface PedidoServiceInterface {

    Pedido registrarPedido(Pedido pedido );

   Pedido traerPorId(Long id);


}
