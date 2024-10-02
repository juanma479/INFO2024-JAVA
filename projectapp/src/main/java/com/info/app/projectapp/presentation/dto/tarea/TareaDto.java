package com.info.app.projectapp.presentation.dto.tarea;

import com.info.app.projectapp.presentation.dto.documento.DocumentoDto;

import java.util.List;
import java.util.UUID;

public record TareaDto(
        String titulo,
        String descripcion,
        UUID uuidProyecto,
        List<DocumentoDto> documentos
) {
}
