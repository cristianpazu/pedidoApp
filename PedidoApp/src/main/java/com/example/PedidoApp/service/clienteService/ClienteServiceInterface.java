package com.example.PedidoApp.service.clienteService;

import com.example.PedidoApp.model.Cliente;
import com.example.PedidoApp.model.DTO.ClienteDTO;
import com.example.PedidoApp.model.DTO.ClienteRespuestaDTO;
import com.example.PedidoApp.model.Productos;

public interface ClienteServiceInterface {

    ClienteDTO registrarCliente(Cliente cliente);

    Cliente traerClienteId(Integer id);






}
