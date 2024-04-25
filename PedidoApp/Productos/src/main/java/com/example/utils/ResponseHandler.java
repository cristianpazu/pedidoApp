package com.example.PedidoApp.utils;

import com.example.PedidoApp.Exceptions.MensajeErrorEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public ResponseEntity<Object> generateResponse(final HttpStatus httpStatus,
                                                   final Object response) {
        final Map<String, Object> map = new HashMap<>();
        map.put("status", HttpStatus.OK.value());
        map.put("payload", response);
        return new ResponseEntity<>(map, httpStatus);
    }

    public ResponseEntity<Object> generateResponseError(final HttpStatus httpStatus,
                                                        final MensajeErrorEnum mensajesErrorEnum) {
        final Map<String, Object> mapRespuesta = new HashMap<>();

        Map<String, Object> mapError = new HashMap<>();
        mapError.put("codigo", mensajesErrorEnum.getCodigo());
        mapError.put("mensajeError", mensajesErrorEnum.getMensajeError());
        mapError.put("recomendacion", mensajesErrorEnum.getRecomendacion());

        mapRespuesta.put("status", httpStatus.value());
        mapRespuesta.put("payload", mapError);
        return new ResponseEntity<>(mapRespuesta, httpStatus);
    }

}
