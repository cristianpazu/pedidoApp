package com.example.PedidoApp.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRespuestaDTO {



    Long idCliente;


    Integer documento;

    String nombre;


    String apellido;


    String direccion;


    String correo;


    String celular;

    String estado;
}
