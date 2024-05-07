package com.example.PedidoApp.controller.PedidoController;

import com.example.PedidoApp.model.Pedido;
import com.example.PedidoApp.model.Productos;
import com.example.PedidoApp.reports.venta.ventaReport;
import com.example.PedidoApp.service.Pedido.impl.PedidoServiceImpl;
import com.example.PedidoApp.utils.ResponseHandler;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    private final ventaReport ventaReports;

    Pedido pedido = new Pedido();

    @Autowired
    PedidoServiceImpl pedidoService;


    @Autowired
    public PedidoController(ventaReport ventaReportspdf, PedidoServiceImpl pedidoService) {

        this.ventaReports = ventaReportspdf;
        this.pedidoService = pedidoService;
    }


    @PostMapping("/registrarPedido")
    public ResponseEntity<Object> registrarPedido(@RequestBody Pedido pedido) {


        return new ResponseHandler().generateResponse(HttpStatus.OK, pedidoService.registrarPedido(pedido));


    }


    @GetMapping("/traerporId/{id}")
    public ResponseEntity<Object> traerProducto(@PathVariable Long id) {

        return new ResponseHandler().generateResponse(HttpStatus.OK, pedidoService.traerPorId(id));

    }


    @GetMapping("/generate-pdf/{id}")
    public void generarPdfVenta(HttpServletResponse response, @PathVariable Long id) throws Exception {

        ventaReports.ventaReports(response, pedidoService.traerPorId(id));

    }


}
