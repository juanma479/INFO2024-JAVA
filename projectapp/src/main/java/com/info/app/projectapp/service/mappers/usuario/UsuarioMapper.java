package com.info.app.projectapp.service.mappers.usuario;

import com.info.app.projectapp.persistance.domain.Usuario;
import com.info.app.projectapp.presentation.dto.usuario.UsuarioDto;

public interface UsuarioMapper {

    Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto);

    UsuarioDto usuarioToUsuarioDto(Usuario usuario);
}
