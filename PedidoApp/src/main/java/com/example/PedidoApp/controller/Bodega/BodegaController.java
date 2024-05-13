package com.example.PedidoApp.controller.Bodega;

import com.example.PedidoApp.model.Bodega;
import com.example.PedidoApp.service.bodegaService.impl.BodegaServiceImpl;
import com.example.PedidoApp.utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Bodega")
public class BodegaController {


    @Autowired
    BodegaServiceImpl bodegaService;

    @PostMapping("/registrarBodega")

    public ResponseEntity<Object> registrarBodega(@RequestBody Bodega bodega) {

        return new ResponseHandler().generateResponse(HttpStatus.OK,bodegaService.registrarBodega(bodega));

    }


    @GetMapping("/listarBodegas")
    public ResponseEntity<Object> listarBodegas() {
        return new ResponseHandler().generateResponse(HttpStatus.OK, bodegaService.traerTodasBoderga());
    }

    @GetMapping("/listarBodega/{id}")
    public ResponseEntity<Object> listarBodega(@PathVariable Long id) {
        return new ResponseHandler().generateResponse(HttpStatus.OK, bodegaService.traerIdBoderga(id));
    }

}
