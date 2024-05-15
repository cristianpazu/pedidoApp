package com.example.PedidoApp.controller.UsuarioController;

import com.example.PedidoApp.model.Categoria;
import com.example.PedidoApp.model.Usuario;
import com.example.PedidoApp.service.categoriaService.impl.CategoriaServiceImpl;
import com.example.PedidoApp.service.usuarioService.impl.UsuarioServiceImpl;
import com.example.PedidoApp.utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioServiceImpl usuarioService;

    @PostMapping("/registrarUsuario")
    public ResponseEntity<Object> registrarUsuario(@RequestBody Usuario usuario){

        return  new ResponseHandler().generateResponse(HttpStatus.OK, usuarioService.registrarUsuario(usuario));

    }
}
