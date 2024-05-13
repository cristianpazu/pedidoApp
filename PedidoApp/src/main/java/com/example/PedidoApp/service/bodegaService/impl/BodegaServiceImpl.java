package com.example.PedidoApp.service.bodegaService.impl;

import com.example.PedidoApp.Exceptions.MensajeErrorEnum;
import com.example.PedidoApp.Exceptions.RequestException;
import com.example.PedidoApp.model.Bodega;
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
    public Bodega registrarBodega(Bodega bodega) {
        try {

            System.out.println("bodegoassss"+bodega);
            return bodegaRepository.save(bodega);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Bodega> traerTodasBoderga() {
        try {

            return bodegaRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Bodega actualizarBodega(Bodega bodega) {
        return null;
    }

    @Override
    public Bodega traerIdBoderga(Long id) {
        try {
            return bodegaRepository.findById(id).orElseThrow(
                    () -> new RequestException(MensajeErrorEnum.BODEGA_NO_ENCONTRADA, HttpStatus.BAD_REQUEST.value()));
        } catch(RuntimeException ex) {
            log.error("traerBodega: ".concat(ex.getMessage())
            );
            throw new RuntimeException(ex);
        }
    }
}
