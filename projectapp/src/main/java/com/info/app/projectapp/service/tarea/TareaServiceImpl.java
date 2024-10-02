package com.info.app.projectapp.service.tarea;

import com.info.app.projectapp.persistance.domain.Documento;
import com.info.app.projectapp.persistance.domain.Proyecto;
import com.info.app.projectapp.persistance.domain.Tarea;
import com.info.app.projectapp.persistance.domain.enums.EstadoTareaEnum;
import com.info.app.projectapp.persistance.repository.proyecto.ProyectoRepository;
import com.info.app.projectapp.persistance.repository.tarea.TareaRepository;
import com.info.app.projectapp.presentation.dto.tarea.TareaCreatedDto;
import com.info.app.projectapp.presentation.dto.tarea.TareaDto;
import com.info.app.projectapp.service.exceptions.ResourceNotFoundException;
import com.info.app.projectapp.service.mappers.documento.DocumentoMapper;
import com.info.app.projectapp.service.mappers.tarea.TareaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TareaServiceImpl implements TareaService{

    private TareaMapper tareaMapper;
    private DocumentoMapper documentoMapper;

    private TareaRepository tareaRepository;
    private ProyectoRepository proyectoRepository;

    @Override
    public Optional<TareaCreatedDto> createTarea(TareaDto tareaDto) {

        Tarea tarea = tareaMapper.tareaDtoToTarea(tareaDto);

        Proyecto proyecto = proyectoRepository.findById(tareaDto.uuidProyecto()).orElseThrow(()
                -> new ResourceNotFoundException("El proyecto con ID "+tareaDto.uuidProyecto()+" no existe"));
        tarea.setProyecto(proyecto);

        if (tareaDto.documentos() != null && !tareaDto.documentos().isEmpty()) {
            List<Documento> documentos = tareaDto.documentos().stream().map(
                    documentoMapper :: documentoDtoToDocumento).collect(Collectors.toList());
            tarea.setDocumentos(documentos);
        }

        proyecto.getTareas().add(tarea);

        Tarea createdTarea = tareaRepository.save(tarea);
        return Optional.of(tareaMapper.tareaToTareaCreatedDto(createdTarea));
    }

    @Override
    public boolean updateEstadoTarea(UUID id, EstadoTareaEnum estadoTareaEnum) {

        Tarea tarea = tareaRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("La tarea con ID "+id+" no existe."));

        tarea.setEstado(estadoTareaEnum);

        try {
            tareaRepository.save(tarea);
            return true;
        } catch (Exception e) {
            return  false;
        }
    }
}
