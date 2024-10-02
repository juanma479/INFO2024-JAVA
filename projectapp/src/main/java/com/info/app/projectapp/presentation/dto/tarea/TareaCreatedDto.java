package com.info.app.projectapp.presentation.dto.tarea;

import com.info.app.projectapp.persistance.domain.enums.EstadoTareaEnum;
import com.info.app.projectapp.presentation.dto.documento.DocumentoDto;

import java.util.List;
import java.util.UUID;

public record TareaCreatedDto(
        UUID id,
        String titulo,
        String descripcion,
        EstadoTareaEnum estado,
        UUID uuidProyecto,
        List<DocumentoDto> documentos
) {
}
