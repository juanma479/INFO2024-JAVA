package com.info.app.projectapp.service.mappers.proyecto;

import com.info.app.projectapp.persistance.domain.Proyecto;
import com.info.app.projectapp.presentation.dto.proyecto.ProyectoCreateDto;
import com.info.app.projectapp.presentation.dto.proyecto.ProyectoCreatedDto;
import com.info.app.projectapp.presentation.dto.proyecto.ProyectoDto;
import com.info.app.projectapp.presentation.dto.proyecto.ProyectoUpdatedDto;

public interface ProyectoMapper {

    ProyectoUpdatedDto proyectoToProyectoUpdatedDto(Proyecto proyecto);

    Proyecto proyectoCreateDtoToProyecto(ProyectoCreateDto proyectoCreateDto);

    ProyectoCreatedDto proyectoToProyectoCreatedDto(Proyecto proyecto);

    ProyectoDto proyectoToProyectoDto(Proyecto proyecto);
}
