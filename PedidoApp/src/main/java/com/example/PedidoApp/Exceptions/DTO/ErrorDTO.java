package com.example.PedidoApp.Exceptions.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {
    private HttpStatus status;
    private String message;



   /* public static ErrorDTO construirError(MensajesErrorEnum mensajeError) {


        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setCodigo(mensajeError.getCodigo());
        errorDTO.setError(mensajeError.getMensajeError());
        errorDTO.setRecomendacion(mensajeError.getRecomendacion());

        return errorDTO;
    } */



}
