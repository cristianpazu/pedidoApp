package com.example.PedidoApp.service.clienteService.impl;

//import com.example.PedidoApp.mappers.ClienteMapper;
import com.example.PedidoApp.model.Cliente;
import com.example.PedidoApp.model.DTO.ClienteDTO;
import com.example.PedidoApp.model.DTO.ClienteRespuestaDTO;
import com.example.PedidoApp.model.Productos;
import com.example.PedidoApp.repository.ClienteRepository.ClienteRepository;
import com.example.PedidoApp.service.clienteService.ClienteServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ClienteServiceImpl implements ClienteServiceInterface {

    @Autowired
    ClienteRepository clienteRepository;


    //private ClienteMapper clienteMapper;


    @Override
    public Cliente registrarCliente(Cliente cliente) {

        //Cliente cliente = clienteMapper.clienteTOclienteDto(clienteDTO);

        if (clienteRepository.findClienteByDocumento(cliente.getDocumento()).isPresent()) {
            throw new RuntimeException("El documento ya esta registrado");
        }
   //     ClienteDTO cliente1 = clienteRepository.findById(cliente.getIdCliente()).orElseThrow(() -> new RuntimeException("hubo un error en el registro"));

        try {
     //       Cliente.builder()
       //                     .nombre(cliente1.getNombre())
         //                           .build();
            cliente.setEstado("A");
            return clienteRepository.save(cliente);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Cliente traerClienteId(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(
                () -> new RuntimeException("La cliente no encontrado"));
        try{
            return cliente;
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
