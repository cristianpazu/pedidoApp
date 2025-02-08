package com.example.PedidoApp.service.bodegaService.impl;

import com.example.PedidoApp.Exceptions.MensajeErrorEnum;
import com.example.PedidoApp.Exceptions.RequestException;
import com.example.PedidoApp.mappers.BodegaMappers;
import com.example.PedidoApp.mappers.ClientesMappers;
import com.example.PedidoApp.model.Bodega;
import com.example.PedidoApp.model.DTO.BodegaDTO;
import com.example.PedidoApp.model.DTO.ClienteDTO;
import com.example.PedidoApp.repository.BodegaRepository.BodegaRepository;
import com.example.PedidoApp.service.bodegaService.BodegaServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class BodegaServiceImpl implements BodegaServiceInterface {

    @Autowired
    BodegaRepository bodegaRepository;

    @Override
    public BodegaDTO registrarBodega(Bodega bodega) {
        try {

            System.out.println("bodegoassss"+bodega);

         //   BodegaDTO bodegaDTO = BodegaMappers.BODEGA_MAPPERS.bodegaToBodegaDTO(bodega);
              return BodegaMappers.BODEGA_MAPPERS.bodegaToBodegaDTO(bodega);
                      //bodegaRepository.save(bodegaDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<BodegaDTO> traerTodasBoderga() {
        try {
           List<Bodega> bg = bodegaRepository.findAll();


            return bg.stream().map(bodegas -> BodegaDTO.builder()

                    .idBodega(bodegas.getIdBodega())
                    .nombre(bodegas.getNombre())
                    .fechaCreacionBodega(bodegas.getFechaCreacionBodega())
                    .build()
            ).toList();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Bodega actualizarBodega(Bodega bodega) {
        return null;
    }

    @Override
    public Bodega traerIdBoderga(Integer id) {
        try {

        Bodega bodegaId =    bodegaRepository.findById(id).orElseThrow(
                    () -> new RequestException(MensajeErrorEnum.BODEGA_NO_ENCONTRADA, HttpStatus.BAD_REQUEST.value()));

            // BodegaDTO bodegaDTOs = BodegaMappers.BODEGA_MAPPERS.bodegaToBodegaDTO(bodegaId);


            return  bodegaId;

        } catch(RuntimeException ex) {
            log.error("traerBodega: ".concat(ex.getMessage())
            );
            throw new RuntimeException(ex);
        }
    }
}
