package com.example.PedidoApp.Exceptions.DTO;

import com.example.PedidoApp.Exceptions.MensajeErrorEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {
    String recomendacion;
    String codigo;
    String error;



    public static ErrorDTO construirError(MensajeErrorEnum mensajeError) {


        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setCodigo(mensajeError.getCodigo());
        errorDTO.setError(mensajeError.getMensajeError());
        errorDTO.setRecomendacion(mensajeError.getRecomendacion());

        return errorDTO;
    }



}
