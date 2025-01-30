package com.example.PedidoApp.mappers;

import com.example.PedidoApp.model.Cliente;
import com.example.PedidoApp.model.DTO.ClienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientesMappers {

ClientesMappers CLIENTES_MAPPERS = Mappers.getMapper(ClientesMappers.class);


ClienteDTO clienteToClienteDTO(Cliente cliente);


}
