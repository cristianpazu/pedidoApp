package com.example.PedidoApp.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum MensajeErrorEnum {
    //GENERICO
    DATOS_NO_ENCONTRADOS(
            "2",
            "No se encontraron datos con la informacion suministrada",
            "Verifique los parametros de busqueda e intente de nuevo"),
    //CLIENTE
    CLIENTE_REGISTRADO(
            "1",
                    "Cliente ya se encuentra registrado",
                    "Verifique el Cliente  que se encuentra creando"),
    CLIENTE_NO_EXITE(
            "1",
            "Cliente no esta registrado",
            "Verifique el nombre de usuario que se encuentra creando"),

    CLIENTE_DOCUMENTO_NO_EXITE(
            "1",
            "El DOCUMENTO esta registrado",
            "Verifique el DOCUMENTO  que se encuentra creando"),

    //Producto
    PRODUCTO_NO_ENCONTRADO(
            "1",
            "Producto ya se encuentra registrado",
            "Verifique el Producto  que se encuentra creando"),
    //Categoria
    CATEGORIA_NO_EXITE(
            "1",
            "Categoria no esta registrado",
            "Verifique el nombre de usuario que se encuentra creando"),

   //Bodega
    BODEGA_REGISTRADO(
            "1",
            "Bodega ya se encuentra registrado",
            "Verifique el nombre de usuario que se encuentra creando"),
    BODEGA_NO_ENCONTRADA(
            "1",
            "Bodega no encontrada",
            "Verifique el nombre de usuario que se encuentra creando");




    private final String codigo;
    private final String mensajeError;
    private final String recomendacion;
}
