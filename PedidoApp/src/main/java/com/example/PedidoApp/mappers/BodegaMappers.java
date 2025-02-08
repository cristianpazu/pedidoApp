package com.example.PedidoApp.mappers;

import com.example.PedidoApp.model.Bodega;
import com.example.PedidoApp.model.DTO.BodegaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BodegaMappers {

    BodegaMappers BODEGA_MAPPERS = Mappers.getMapper(BodegaMappers.class);


BodegaDTO bodegaToBodegaDTO(Bodega bodega);
BodegaDTO bodegaToListBodegaDTO(Bodega bodega);

}
