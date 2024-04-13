package com.example.PedidoApp.controller.PedidoController;

import com.example.PedidoApp.model.Pedido;
import com.example.PedidoApp.model.Productos;
import com.example.PedidoApp.reports.venta.ventaReport;
import com.example.PedidoApp.service.Pedido.impl.PedidoServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    private final ventaReport ventaReports;

    Pedido pedido = new Pedido();

    @Autowired
    PedidoServiceImpl pedidoService;



    @Autowired
    public PedidoController( ventaReport ventaReportspdf, PedidoServiceImpl pedidoService) {

        this.ventaReports = ventaReportspdf;
        this.pedidoService = pedidoService;
    }


    @PostMapping("/registrarPedido")
    public Pedido registrarPedido(@RequestBody Pedido pedido) {
        try {


            return pedidoService.registrarPedido(pedido);
        } catch (Exception e) {
            throw new RuntimeException(e);

        }


    }


    @GetMapping("/traerporId/{id}")
    public Pedido traerProducto(@PathVariable Long id) {

        return pedidoService.traerPorId(id);

    }


    @GetMapping("/generate-pdf/{id}")
    public void generarPdfVenta(HttpServletResponse response, @PathVariable Long id) throws Exception {

        ventaReports.ventaReports(response, pedidoService.traerPorId(id));

    }



}
