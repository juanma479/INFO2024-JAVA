package com.info.app.projectapp.service.proyecto;

import com.info.app.projectapp.persistance.domain.Proyecto;
import com.info.app.projectapp.persistance.domain.Tarea;
import com.info.app.projectapp.persistance.domain.enums.EstadoTareaEnum;
import com.info.app.projectapp.persistance.repository.proyecto.ProyectoRepository;
import com.info.app.projectapp.persistance.repository.tarea.TareaRepository;
import com.info.app.projectapp.persistance.repository.usuario.UsuarioRepository;
import com.info.app.projectapp.presentation.dto.proyecto.ProyectoCreateDto;
import com.info.app.projectapp.presentation.dto.proyecto.ProyectoCreatedDto;
import com.info.app.projectapp.presentation.dto.proyecto.ProyectoDto;
import com.info.app.projectapp.presentation.dto.proyecto.ProyectoUpdatedDto;
import com.info.app.projectapp.service.exceptions.BusinessException;
import com.info.app.projectapp.service.exceptions.ResourceNotFoundException;
import com.info.app.projectapp.service.mappers.proyecto.ProyectoMapper;
import com.info.app.projectapp.service.tarea.TareaService;
import com.info.app.projectapp.service.usuario.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProyectoServiceImpl implements ProyectoService{

    private final UsuarioRepository usuarioRepository;
    private ProyectoRepository proyectoRepository;
    private TareaRepository tareaRepository;

    private ProyectoMapper proyectoMapper;

    private UsuarioService usuarioService;
    private TareaService tareaService;


    @Override
    public Proyecto getProyectoById(UUID id) {

        Optional<Proyecto> optionalProyecto = proyectoRepository.findById(id);

        if (optionalProyecto.isPresent()) {
            return optionalProyecto.get();
        } else {
            throw new NoSuchElementException("Proyecto no encontrado");
        }
    }


    @Override
    public Optional<ProyectoDto> getProyectoDtoById(UUID uuid) {
        Optional<Proyecto> optionalProyecto = proyectoRepository.findById(uuid);

        if(optionalProyecto.isPresent()) {
            return Optional.of(
                    proyectoMapper.proyectoToProyectoDto(optionalProyecto.get())
            );
        } else {
            return Optional.empty();
        }
    }


    @Override
    public Optional<ProyectoUpdatedDto> closeProyecto(UUID uuid) {
        Optional<Proyecto> proyecto = proyectoRepository.findById(uuid);

        if( proyecto.isPresent()) {
            var proyectoEncontrado = proyecto.get();

            List<Tarea> tareas = tareaRepository.findByProyectoId(uuid);
            for(Tarea tarea : tareas) {
                boolean tareaClosed = tareaService.updateEstadoTarea(tarea.getId(), EstadoTareaEnum.COMPLETA);

                if (!tareaClosed) {
                    throw new BusinessException("Error al cerrar la tarea con ID "+tarea.getId());
                }
            }

            proyectoEncontrado.setFechaFin(LocalDate.now());
            var proyectoUpdated = proyectoRepository.save(proyectoEncontrado);
            return Optional.of(proyectoMapper.proyectoToProyectoUpdatedDto(proyectoUpdated));
        }

        return Optional.empty();
    }


    @Override
    public Optional<ProyectoCreatedDto> createProyecto(ProyectoCreateDto proyectoCreateDto) {
        Proyecto newProyecto = proyectoMapper.proyectoCreateDtoToProyecto(proyectoCreateDto);

        if (!proyectoCreateDto.colaboradoresId().isEmpty()) {
            for (UUID colaboradorId : proyectoCreateDto.colaboradoresId()){
                usuarioService.usuarioExists(colaboradorId);

                if (proyectoRepository.existsByColaboradores_Id(colaboradorId)) {
                    throw new BusinessException("El colaborador con ID "+colaboradorId+" ya tiene asignado un proyecto");
                }
            }

        }

        UUID liderId = proyectoCreateDto.liderid();
        if (liderId != null) {
            usuarioService.usuarioExists(liderId);

            if (proyectoRepository.existsByLider_Id(liderId)) {
                throw new BusinessException("El usuario con ID "+liderId+" ya lidera otro proyecto.");
            }
        }

        return Optional.of(
                proyectoMapper.proyectoToProyectoCreatedDto( proyectoRepository.save( newProyecto))
        );
    }


    @Override
    public List<ProyectoDto> getAllProyectos() {
        return proyectoRepository.findAll().stream()
                .map( proyecto -> proyectoMapper.proyectoToProyectoDto(proyecto)).toList();
    }

}
