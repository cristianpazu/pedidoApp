package com.example.PedidoApp.utils;




import com.example.PedidoApp.Exceptions.MensajeErrorEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.concurrent.atomic.AtomicReference;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Object> runtimeException(RuntimeException ex) {

        log.error(ex.getMessage());
        log.error(ex.getClass().toString());
        return ResponseHandler.error(
                MensajeErrorEnum.ERROR_DESCONOCIDO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<Object> requestException(RequestException ex) {

        return ResponseHandler.error(
                ex.getMensajeErrorEnum(), HttpStatus.BAD_REQUEST);
    }






}
