package com.info.app.projectapp.service.tarea;

import com.info.app.projectapp.persistance.domain.enums.EstadoTareaEnum;
import com.info.app.projectapp.presentation.dto.tarea.TareaCreatedDto;
import com.info.app.projectapp.presentation.dto.tarea.TareaDto;

import java.util.Optional;
import java.util.UUID;

public interface TareaService {

    Optional<TareaCreatedDto> createTarea(TareaDto tareaDto);

    boolean updateEstadoTarea(UUID id, EstadoTareaEnum estadoTareaEnum);

    boolean deleteTarea(UUID idTarea);
}
