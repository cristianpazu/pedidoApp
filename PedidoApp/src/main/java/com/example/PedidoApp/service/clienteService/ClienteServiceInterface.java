package com.example.PedidoApp.service.clienteService;

import com.example.PedidoApp.model.Cliente;
import com.example.PedidoApp.model.DTO.ClienteDTO;
import com.example.PedidoApp.model.Productos;

public interface ClienteServiceInterface {

    Cliente registrarCliente(Cliente cliente);

    Cliente traerClienteId(Long id);






}
