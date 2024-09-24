package com.info.app.projectapp.presentation.dto.usuario;

import com.info.app.projectapp.persistance.domain.enums.RolEnum;

import java.util.UUID;

public record UsuarioDto(
        String nombre,
        String email,
        RolEnum rol,
        UUID idProyecto
) {
}
