package com.info.app.projectapp.service.usuario;

import com.info.app.projectapp.persistance.domain.Proyecto;
import com.info.app.projectapp.persistance.domain.Usuario;
import com.info.app.projectapp.persistance.repository.proyecto.ProyectoRepository;
import com.info.app.projectapp.persistance.repository.usuario.UsuarioRepository;
import com.info.app.projectapp.presentation.dto.usuario.UsuarioDto;
import com.info.app.projectapp.service.mappers.usuario.UsuarioMapper;
import com.info.app.projectapp.service.proyecto.ProyectoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService{

    private UsuarioMapper usuarioMapper;

    private ProyectoService proyectoService;

    private ProyectoRepository proyectoRepository;

    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDto createUsuario(UsuarioDto usuario) {

        Usuario usuarioCreated = usuarioMapper.usuarioDtoToUsuario(usuario);

        Proyecto proyecto = proyectoService.getProyectoById(usuario.idProyecto());

        usuarioCreated.setProyecto(proyecto);
//        proyecto.setUsuarioByRol(usuarioCreated);

//        proyectoRepository.save(proyecto);
        return usuarioMapper.usuarioToUsuarioDto(usuarioRepository.save(usuarioCreated));
    }
}
