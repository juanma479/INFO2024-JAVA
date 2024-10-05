package com.info.app.projectapp.service.usuario;

import com.info.app.projectapp.presentation.dto.usuario.UsuarioDto;

import java.util.UUID;

public interface UsuarioService {

    UsuarioDto createUsuario(UsuarioDto usuario);

    boolean usuarioExists(UUID id);
}
