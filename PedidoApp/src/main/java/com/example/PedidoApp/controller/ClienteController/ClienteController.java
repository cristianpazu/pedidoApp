package com.example.PedidoApp.controller.ClienteController;

import com.example.PedidoApp.model.Cliente;
import com.example.PedidoApp.model.DTO.ClienteDTO;
import com.example.PedidoApp.model.DTO.ClienteRespuestaDTO;
import com.example.PedidoApp.service.clienteService.impl.ClienteServiceImpl;
import com.example.PedidoApp.utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService;

    @PostMapping("/registrarCliente")
    public ResponseEntity<Object> registrarClientes(@RequestBody Cliente cliente) {
        try {
            return new ResponseHandler().generateResponse(
                    HttpStatus.OK, clienteService.registrarCliente(cliente)
            );
                    //ResponseEntity<>(  clienteService.registrarCliente(cliente), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @GetMapping("/traerClienteid/{id}")
    public ResponseEntity<Object> ClientePorId(@PathVariable Long id) {
        try {

            return new ResponseHandler().generateResponse(
                    HttpStatus.OK,clienteService.traerClienteId(id));


        } catch (Exception e) {
            throw new RuntimeException(e);

        }


    }
}
