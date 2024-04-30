package com.example.PedidoApp.controller.Bodega;

import com.example.PedidoApp.model.Bodega;
import com.example.PedidoApp.service.bodegaService.impl.BodegaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Bodega")
public class BodegaController {


    @Autowired
    BodegaServiceImpl bodegaService;

    @PostMapping("/registrarBodega")

    public Bodega registrarBodega(Bodega bodega) {

        return bodegaService.registrarBodega(bodega);

    }


    @GetMapping("/listarBodegas")
    public List<Bodega> listarBodegas() {
        return bodegaService.traerTodasBoderga();
    }

    @GetMapping("/listarBodega/{id}")
    public Bodega listarBodega(Long id) {
        return bodegaService.traerIdBoderga(id);
    }

}
