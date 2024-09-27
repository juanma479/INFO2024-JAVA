package com.info.app.projectapp.service.mappers.proyecto;

import com.info.app.projectapp.persistance.domain.Proyecto;
import com.info.app.projectapp.presentation.dto.proyecto.ProyectoCreateDto;
import com.info.app.projectapp.presentation.dto.proyecto.ProyectoCreatedDto;
import com.info.app.projectapp.presentation.dto.proyecto.ProyectoDto;
import com.info.app.projectapp.presentation.dto.proyecto.ProyectoUpdatedDto;
import com.info.app.projectapp.service.mappers.usuario.UsuarioMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
@AllArgsConstructor
public class ProyectoMapperImpl implements ProyectoMapper{

    private UsuarioMapper usuarioMapper;

    @Override
    public ProyectoUpdatedDto proyectoToProyectoUpdatedDto(Proyecto proyecto) {

        return new ProyectoUpdatedDto(
                proyecto.getNombre(),
                proyecto.getFechaInicio(),
                proyecto.getFechaFin(),
                usuarioMapper.usuarioToUsuarioDto(proyecto.getLider()));
    }


    @Override
    public Proyecto proyectoCreateDtoToProyecto(ProyectoCreateDto proyectoCreateDto) {

        Proyecto proyecto = new Proyecto();
        proyecto.setId(UUID.randomUUID());
        proyecto.setFechaInicio(LocalDate.now());
        proyecto.setNombre(proyectoCreateDto.nombre());
        return proyecto;
    }


    @Override
    public ProyectoCreatedDto proyectoToProyectoCreatedDto(Proyecto proyecto) {
        return new ProyectoCreatedDto(
                proyecto.getId(),
                proyecto.getNombre(),
                proyecto.getFechaInicio(),
                usuarioMapper.usuarioToUsuarioDto(proyecto.getLider()),
                proyecto.getColaboradores()
                        .stream().map(colaborador -> usuarioMapper.usuarioToUsuarioDto(colaborador)).toList()
        );
    }

    @Override
    public ProyectoDto proyectoToProyectoDto(Proyecto proyecto) {
        return new ProyectoDto(
                proyecto.getId(),
                proyecto.getNombre(),
                proyecto.getFechaInicio(),
                proyecto.getFechaFin(),
                usuarioMapper.usuarioToUsuarioDto(proyecto.getLider()),
                proyecto.getColaboradores().stream()
                        .map( colaborador -> usuarioMapper.usuarioToUsuarioDto(colaborador)).toList()
        );
    }
}
