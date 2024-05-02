package com.example.PedidoApp.service.Pedido.impl;

import com.example.PedidoApp.model.*;
import com.example.PedidoApp.model.DTO.ClienteDTO;
import com.example.PedidoApp.repository.BodegaRepository.BodegaRepository;
import com.example.PedidoApp.repository.ClienteRepository.ClienteRepository;
import com.example.PedidoApp.repository.Pedido.PedidoRepository;
import com.example.PedidoApp.repository.ProductoRepository.ProductoRepository;
import com.example.PedidoApp.service.Pedido.PedidoServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PedidoServiceImpl implements PedidoServiceInterface {
    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ProductoRepository productoRepository;


    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    BodegaRepository bodegaRepository;

    @Override
    public Pedido registrarPedido(Pedido pedido) {

        Set<Productos> productosList = pedido.getProductos().stream()
                .map(producto -> productoRepository.findById(producto.getIdProductos()).orElseThrow(
                        () -> new RuntimeException("Producto no encontrada")
                )).collect(Collectors.toSet());

        Productos pro = new Productos();
        Set<Bodega> bodegaList = pro.getBodega().stream()
                .map(bodega -> bodegaRepository.findById(bodega.getIdBodega()).orElseThrow(
                        () -> new RuntimeException("Producto no encontrada")
                )).collect(Collectors.toSet());

        List<Productos> ped = pedido.getProductos().stream().collect(Collectors.toList());


        Productos productoPedido = null;
        Bodega bodegass = null;


        Bodega bodega = new Bodega();
        // Integer bds =
        //System.out.println("bds = " + bds);
        for (Productos pr : productosList) {
            productoPedido = pr;


            Productos ped2 = null;
            for (Productos pr2 : ped) {
                ped2 = pr2;

                if (productoPedido.getIdProductos().equals(ped2.getIdProductos())) {
                    productoPedido.setCantidad(ped2.getCantidad());


                    for (Bodega br : bodegaList) {
                        System.out.println("bodegaList = " + br.getStocks().getCantidadStock());
                        //br.set();

                        if (br.getStocks().getCantidadStock() == 0) {
                            throw new RuntimeException("No hay suficiente stock disponible para el producto");
                        }

                        int stockActualizado = br.getStocks().getCantidadStock() - ped2.getCantidad();
                        System.out.println(">>>>>>>>>>>><<<<<<<<<<<<<<<<<" + br.getStocks().getCantidadStock());
                        for (Bodega psa : bodegaList) {
                            bodegass = psa;
                            System.out.println(">>>>>>>>>>>><<<<<<<<<<<<<<<<<" + bodegass.getStocks().getCantidadStock());
                            bodegass.getStocks().setCantidadStock(stockActualizado);
                        }
                    }


                } else {
                    System.out.println("no se puede");


                }


            }


        }


        double total = productosList.stream()// Filtra productos nulos
                .mapToDouble(producto -> producto.getPrecio() != null ? producto.getPrecio() : 0)
                .sum();

        System.out.println("total = " + total);

        Cliente clientes = clienteRepository.findById(pedido.getClientes().getIdCliente()).orElseThrow
                (() -> new RuntimeException("Cliente no encontrado con ID: " + pedido.getClientes().getIdCliente()));
        log.info("clientes:" + clientes.getNombre());
        try {

            Date fecha = new Date();
            SimpleDateFormat df = new SimpleDateFormat("EEEE dd,MMMM, yyyy");
            String fechaStr = df.format(fecha);

            pedido.setProductos(productosList);
            pedido.setClientes(clientes);
            pedido.setTotal(total);
            pedido.setFechaPedido(fechaStr);
            pedidoRepository.save(pedido);
            return pedido;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public Pedido traerPorId(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("El pedido no encontrado"));
        try {

            return pedido;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
