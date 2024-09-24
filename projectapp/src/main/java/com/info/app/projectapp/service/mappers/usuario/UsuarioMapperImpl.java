package com.info.app.projectapp.service.mappers.usuario;

import com.info.app.projectapp.persistance.domain.Usuario;
import com.info.app.projectapp.presentation.dto.usuario.UsuarioDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UsuarioMapperImpl  implements  UsuarioMapper{


    @Override
    public Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto) {

        Usuario usuarioCreate = new Usuario();
        usuarioCreate.setId(UUID.randomUUID());
        usuarioCreate.setNombre(usuarioDto.nombre());
        usuarioCreate.setEmail(usuarioDto.email());
        usuarioCreate.setRol(usuarioDto.rol());

        return usuarioCreate;
    }

    @Override
    public UsuarioDto usuarioToUsuarioDto(Usuario usuario) {

        return new UsuarioDto(
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getRol(),
                usuario.getProyecto().getId()
        );
    }
}
