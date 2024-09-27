package com.info.app.projectapp.presentation.dto.proyecto;

import java.util.List;
import java.util.UUID;

public record ProyectoCreateDto(String nombre, List<UUID> colaboradoresId, UUID liderid) {
}
