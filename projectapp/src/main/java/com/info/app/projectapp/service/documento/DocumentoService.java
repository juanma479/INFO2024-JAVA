package com.info.app.projectapp.service.documento;

import com.info.app.projectapp.presentation.dto.documento.DocumentoDto;

import java.util.Optional;

public interface DocumentoService {

    Optional<DocumentoDto> createDocumento(DocumentoDto documentoDto);

}
