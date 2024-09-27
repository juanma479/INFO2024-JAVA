package com.info.app.projectapp.service.proyecto;


import com.info.app.projectapp.persistance.domain.Proyecto;
import com.info.app.projectapp.presentation.dto.proyecto.ProyectoCreateDto;
import com.info.app.projectapp.presentation.dto.proyecto.ProyectoCreatedDto;
import com.info.app.projectapp.presentation.dto.proyecto.ProyectoDto;
import com.info.app.projectapp.presentation.dto.proyecto.ProyectoUpdatedDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProyectoService {

    Proyecto getProyectoById(UUID id);

    Optional<ProyectoDto> getProyectoDtoById(UUID uuid);

    Optional<ProyectoUpdatedDto> closeProyecto(UUID uuid);

    Optional<ProyectoCreatedDto> createProyecto(ProyectoCreateDto proyectoCreateDto);

    List<ProyectoDto> getAllProyectos();
}
