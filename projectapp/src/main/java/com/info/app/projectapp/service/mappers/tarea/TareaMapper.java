package com.info.app.projectapp.service.mappers.tarea;

import com.info.app.projectapp.persistance.domain.Tarea;
import com.info.app.projectapp.presentation.dto.tarea.TareaCreatedDto;
import com.info.app.projectapp.presentation.dto.tarea.TareaDto;

public interface TareaMapper {

    Tarea tareaDtoToTarea(TareaDto tareaDto);

    TareaCreatedDto tareaToTareaCreatedDto( Tarea tarea);
}
