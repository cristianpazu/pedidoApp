package com.example.PedidoApp.service.Pedido.impl;

import com.example.PedidoApp.Exceptions.MensajeErrorEnum;
import com.example.PedidoApp.utils.RequestException;
import com.example.PedidoApp.model.*;
import com.example.PedidoApp.model.DTO.ClienteDTO;
import com.example.PedidoApp.repository.BodegaRepository.BodegaRepository;
import com.example.PedidoApp.repository.ClienteRepository.ClienteRepository;
import com.example.PedidoApp.repository.Pedido.PedidoRepository;
import com.example.PedidoApp.repository.ProductoRepository.ProductoRepository;
import com.example.PedidoApp.repository.UsuarioRepository.UsuarioRepository;
import com.example.PedidoApp.service.Pedido.PedidoServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

import static com.example.PedidoApp.Exceptions.MensajeErrorEnum.*;

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

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Pedido registrarPedido(Pedido pedido) {
        try {

            Cliente clientes = clienteRepository.findById(pedido.getClientes().getIdCliente()).orElseThrow
                    (() -> new RuntimeException("Cliente no encontrado con ID: " + pedido.getClientes().getIdCliente()));

            Usuario usuarios = usuarioRepository.findById(pedido.getUsuario().getIdUsuario()).orElseThrow
                    (() -> new RuntimeException("Usuario no encontrado con ID: " + pedido.getUsuario().getIdUsuario()));
            System.out.println("clientes = " + clientes);

            log.info("clientes:" + clientes.getNombre());


        System.out.println("asddddddddddd"+ pedido);
        Set<Productos> productosList = pedido.getProductos().stream()
                .map(producto -> productoRepository.findById(producto.getIdProductos()).orElseThrow(
                        () -> new RequestException(MensajeErrorEnum.PRODUCTO_NO_ENCONTRADO)
                )).collect(Collectors.toSet());


        System.out.println("productosList = " + productosList);
        List<Productos> ped = pedido.getProductos().stream().collect(Collectors.toList());

        System.out.println("ped = " + ped);

        Productos productoPedido = new Productos();




        for (Productos pr : productosList) {
            productoPedido = pr;


            Productos ped2 = null;
            for (Productos pr2 : ped) {
                ped2 = pr2;

                if (productoPedido.getIdProductos().equals(ped2.getIdProductos())) {
                    productoPedido.setCantidad(ped2.getCantidad());


                    Date todayDate = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String fechaActual = sdf.format(todayDate);
                    System.out.println("fechaActual =>>>>>>>>>>>>>> " + productoPedido.getFechaVencimiento());

                    if (fechaActual.compareTo(String.valueOf(productoPedido.getFechaVencimiento())) > 0) {
                        System.out.println("fechaActual = " + fechaActual);
                        System.out.println("productoPedido.getFechaVencimiento() = " + productoPedido.getFechaVencimiento());
                        throw new RequestException(FECHA_VENCIMIENTO);

                        //throw new RuntimeException("Proeducto vencido");
                    }


                        if (productoPedido.getStocks().getCantidadStock() == 0) {
                            throw new RequestException(SIN_STOCK);
                        }

                        int stockActualizado = productoPedido.getStocks().getCantidadStock() - ped2.getCantidad();

                    if (stockActualizado < 0) {
                        throw new RequestException(MensajeErrorEnum.CANTIDAD);
                    }

                    productoPedido.getStocks().setCantidadStock(stockActualizado);


                } else {
                    System.out.println("no se puede");


                }


            }


        }


        double total = productosList.stream()// Filtra productos nulos
                .mapToDouble(producto -> producto.getPrecio() != null ? producto.getPrecio() : 0)
                .sum();

        System.out.println("total = " + total);




            Date fecha = new Date();
            SimpleDateFormat df = new SimpleDateFormat("EEEE dd,MMMM, yyyy");
            String fechaStr = df.format(fecha);
            pedido.setTotal(total);
            pedido.setFechaPedido(fechaStr);
            pedido.setProductos(productosList);
            pedido.setClientes(clientes);
            pedido.setUsuario(usuarios);

            System.out.println("pedido = " + pedido);
            pedidoRepository.save(pedido);
            return pedido;

        } catch (RequestException ex) {
            ex.printStackTrace();
            throw new RequestException(ex.getMensajeErrorEnum());

        }


    }

    @Override
    public Pedido traerPorId(Integer id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(
                () -> new RequestException(PEDIDO_NO_ENCONTRADO));
        try {

            return pedido;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Pedido> traerTodoPedido() {

        try{


            return pedidoRepository.findAll();

        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

}
