package com.example.PedidoApp.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum MensajeErrorEnum {
    CLIENTE_REGISTRADO(
            "1",
                    "Usuario ya se encuentra registrado",
                    "Verifique el nombre de usuario que se encuentra creando"),
    DATOS_NO_ENCONTRADOS(
            "2",
                    "No se encontraron datos con la informacion suministrada",
                    "Verifique los parametros de busqueda e intente de nuevo");



    private final String codigo;
    private final String mensajeError;
    private final String recomendacion;
}
