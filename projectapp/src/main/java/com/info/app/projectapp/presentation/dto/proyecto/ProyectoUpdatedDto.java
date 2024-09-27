package com.info.app.projectapp.presentation.dto.proyecto;

import com.info.app.projectapp.presentation.dto.usuario.UsuarioDto;

import java.time.LocalDate;

public record ProyectoUpdatedDto(String nombre, LocalDate fechaInicio, LocalDate fechaFin, UsuarioDto lider ) {
}
