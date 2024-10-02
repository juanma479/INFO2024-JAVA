package com.info.app.projectapp.service.mappers.documento;

import com.info.app.projectapp.persistance.domain.Documento;
import com.info.app.projectapp.presentation.dto.documento.DocumentoDto;

public interface DocumentoMapper {

    Documento documentoDtoToDocumento(DocumentoDto documentoDto);

    DocumentoDto documentoToDocumentoDto(Documento documento);
}
