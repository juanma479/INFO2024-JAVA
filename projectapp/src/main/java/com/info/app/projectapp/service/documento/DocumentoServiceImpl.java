package com.info.app.projectapp.service.documento;

import com.info.app.projectapp.persistance.domain.Documento;
import com.info.app.projectapp.presentation.dto.documento.DocumentoDto;
import com.info.app.projectapp.service.mappers.documento.DocumentoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DocumentoServiceImpl implements DocumentoService{

    private DocumentoMapper documentoMapper;

    @Override
    public Optional<DocumentoDto> createDocumento(DocumentoDto documentoDto) {

        Documento documento = documentoMapper.documentoDtoToDocumento(documentoDto);
        return Optional.empty();
    }
}
