package com.example.PedidoApp.utils;

import com.example.PedidoApp.Exceptions.MensajeErrorEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestException extends RuntimeException {
    private final MensajeErrorEnum mensajeErrorEnum;
}
