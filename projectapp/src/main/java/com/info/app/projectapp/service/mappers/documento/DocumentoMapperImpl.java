package com.info.app.projectapp.service.mappers.documento;

import com.info.app.projectapp.persistance.domain.Documento;
import com.info.app.projectapp.presentation.dto.documento.DocumentoDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@AllArgsConstructor
public class DocumentoMapperImpl implements DocumentoMapper{
    @Override
    public Documento documentoDtoToDocumento(DocumentoDto documentoDto) {

        Documento documento = new Documento();
        documento.setNombre(documentoDto.nombre());
        documento.setUrl(documentoDto.url());
        documento.setFechaCreacion(LocalDate.now());
        return documento;
    }

    @Override
    public DocumentoDto documentoToDocumentoDto(Documento documento) {
        return new DocumentoDto(
                documento.getNombre(),
                documento.getUrl()
        );
    }
}
