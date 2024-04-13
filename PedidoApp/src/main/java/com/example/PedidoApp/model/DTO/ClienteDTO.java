package com.example.PedidoApp.model.DTO;

import com.example.PedidoApp.model.Cliente;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO extends Cliente {



    Long idCliente;


    Integer documento;

    String nombre;


    String apellido;


    String direccion;


    String correo;


    String celular;

    String estado;

}
