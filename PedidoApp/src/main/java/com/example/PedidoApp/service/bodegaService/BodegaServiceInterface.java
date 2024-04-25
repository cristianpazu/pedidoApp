package com.example.PedidoApp.service.bodegaService;

import com.example.PedidoApp.model.Bodega;

import java.util.List;

public interface BodegaServiceInterface {


    Bodega registrarBodega(Bodega bodega);

    List<Bodega> traerTodasBoderga();
    Bodega actualizarBodega(Bodega bodega);
    Bodega traerIdBoderga(Long id);


}
