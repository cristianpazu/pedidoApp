package com.example.PedidoApp.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestException extends RuntimeException {
    private final Integer status;
    private final MensajeErrorEnum mensajesErrorEnum;

    public RequestException(MensajeErrorEnum mensajesErrorEnum, Integer status) {
        this.status = status;
        this.mensajesErrorEnum = mensajesErrorEnum;
    }
}