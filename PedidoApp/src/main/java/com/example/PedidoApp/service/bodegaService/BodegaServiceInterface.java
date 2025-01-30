package com.example.PedidoApp.service.bodegaService;

import com.example.PedidoApp.model.Bodega;
import com.example.PedidoApp.model.DTO.BodegaDTO;

import java.util.List;

public interface BodegaServiceInterface {


    BodegaDTO registrarBodega(Bodega bodega);

    List<BodegaDTO> traerTodasBoderga();
    Bodega actualizarBodega(Bodega bodega);
    Bodega traerIdBoderga(Integer id);


}
