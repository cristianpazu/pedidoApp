package com.example.PedidoApp.Exceptions.DTO;

import com.example.PedidoApp.Exceptions.MensajeErrorEnum;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class GenericoDTO {

    private Integer status;
    private Object payload;

    public static GenericoDTO correcto(Object data) {

        GenericoDTO genericDto = new GenericoDTO();
        genericDto.setStatus(HttpStatus.OK.value());
        genericDto.setPayload(data);

        return genericDto;
    }

    public static GenericoDTO error(MensajeErrorEnum mensajeError, Integer httpStatus) {

        GenericoDTO genericDto = new GenericoDTO();
        genericDto.setStatus(httpStatus);
        genericDto.setPayload(ErrorDTO.construirError(mensajeError));

        return genericDto;
    }

}
