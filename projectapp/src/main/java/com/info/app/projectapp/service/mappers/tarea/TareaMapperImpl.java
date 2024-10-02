package com.info.app.projectapp.service.mappers.tarea;
import com.info.app.projectapp.persistance.domain.Tarea;
import com.info.app.projectapp.persistance.domain.enums.EstadoTareaEnum;
import com.info.app.projectapp.presentation.dto.tarea.TareaCreatedDto;
import com.info.app.projectapp.presentation.dto.tarea.TareaDto;
import com.info.app.projectapp.service.mappers.documento.DocumentoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
@AllArgsConstructor
public class TareaMapperImpl implements TareaMapper{

    public DocumentoMapper documentoMapper;

    @Override
    public Tarea tareaDtoToTarea(TareaDto tareaDto) {
        Tarea tarea = new Tarea();
        tarea.setId(UUID.randomUUID());
        tarea.setTitulo(tareaDto.titulo());
        tarea.setDescripcion(tareaDto.descripcion());
        tarea.setEstado(EstadoTareaEnum.PENDIENTE);
        return tarea;
    }

    @Override
    public TareaCreatedDto tareaToTareaCreatedDto(Tarea tarea) {

        return new TareaCreatedDto(
                tarea.getId(),
                tarea.getTitulo(),
                tarea.getDescripcion(),
                tarea.getEstado(),
                tarea.getProyecto().getId(),
                tarea.getDocumentos().stream().map(
                        documento -> documentoMapper.documentoToDocumentoDto(documento)).toList()
        );
    }
}
