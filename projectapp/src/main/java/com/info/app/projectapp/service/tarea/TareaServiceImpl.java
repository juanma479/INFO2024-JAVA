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
import com.info.app.projectapp.service.proyecto.ProyectoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
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

    private ProyectoService proyectoService;

    @Override
    public Optional<TareaCreatedDto> createTarea(TareaDto tareaDto) {

        Tarea tarea = tareaMapper.tareaDtoToTarea(tareaDto);

        Proyecto proyecto = proyectoService.getProyectoById(tareaDto.uuidProyecto());

        if (CollectionUtils.isEmpty(tareaDto.documentos())) {
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

    @Override
    public boolean deleteTarea(UUID idTarea) {

        if (tareaRepository.existsById(idTarea)) {
            tareaRepository.deleteById(idTarea);
            return true;
        }
        return false;
    }
}
