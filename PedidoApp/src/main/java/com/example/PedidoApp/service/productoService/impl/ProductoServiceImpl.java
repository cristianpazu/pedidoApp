package com.example.PedidoApp.service.productoService.impl;

import com.example.PedidoApp.model.Bodega;
import com.example.PedidoApp.model.Categoria;
import com.example.PedidoApp.model.Productos;
import com.example.PedidoApp.repository.BodegaRepository.BodegaRepository;
import com.example.PedidoApp.repository.CategoriaRepository.CategoriaRepository;
import com.example.PedidoApp.repository.ProductoRepository.ProductoRepository;
import com.example.PedidoApp.service.productoService.ProductoServiceInterface;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductoServiceImpl implements ProductoServiceInterface {


    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private BodegaRepository bodegaRepository;

    @Override
    public Productos registrarProducto(Productos productos) {
        if (productoRepository.findByIdProductos(productos.getIdProductos()).isPresent()) {
            System.out.println("El producto ya registrado");
        }
        try {
            Set<Categoria> categoriasList = productos.getCategorias().stream()
                    .map(modulo -> categoriaRepository.findById(modulo.getIdCategoria()).orElseThrow(
                            () -> new RuntimeException("Categoria no encontrada")
                    )).collect(Collectors.toSet());
            System.out.println(productos.getBodega());
            Set<Bodega> bodegaList = productos.getBodega().stream()
                    .map(bodegas -> bodegaRepository.findById(bodegas.getIdBodega()).orElseThrow(
                            () -> new RuntimeException("Bodega no encontrada")
                    )).collect(Collectors.toSet());

         // Bodega bodegaList = bodegaRepository.findById(productos.getStocks().getBodega().getIdBodega()).orElseThrow(() -> new RuntimeException("Bodega no encontrada"));

            for (Bodega da : bodegaList){
                System.out.println("bodegaList = " + da.getStocks().getCantidadStock());

            }


            if (productos.getIva() > 0) {

                double total = productos.getIva() / 100;
                double totalIvaProducto = productos.getPrecio() * total;
                double totalProducto = totalIvaProducto + productos.getPrecio();

                productos.setPrecio(totalProducto);
            }
            Date fecha = new Date();
            SimpleDateFormat df = new SimpleDateFormat("EEEE dd,MMMM, yyyy hh:mm aa");
            String fechaStr = df.format(fecha);
            productos.setFechaIngreso(fechaStr);
            productos.setCategorias(categoriasList);
            productos.setBodega(bodegaList);

            System.out.println("productos.getCantidad() = " + productos.getCantidad());
            productoRepository.save(productos);
            return productos;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Productos> traerTodoProducto() {
        List<Productos> Product = productoRepository.findAll();
        try {
            if (Product.isEmpty()) {
                log.info("consultarProductos: " + Product);
                throw new RuntimeException("La lista esta vacia");
            }
            return Product;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Productos traerProductoId(Long id) {

        Productos producto = productoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("La Prodcuto no encontrado"));
        try {

            return producto;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
