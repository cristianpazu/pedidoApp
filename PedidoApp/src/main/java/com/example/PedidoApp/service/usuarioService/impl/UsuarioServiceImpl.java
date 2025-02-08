package com.example.PedidoApp.service.usuarioService.impl;

import com.example.PedidoApp.model.Usuario;
import com.example.PedidoApp.repository.ClienteRepository.ClienteRepository;
import com.example.PedidoApp.repository.UsuarioRepository.UsuarioRepository;
import com.example.PedidoApp.service.usuarioService.UsuarioServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UsuarioServiceImpl implements UsuarioServiceInterface {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        try {

            return usuarioRepository.save(usuario);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}

