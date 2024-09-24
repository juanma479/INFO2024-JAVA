package com.info.app.projectapp.persistance.repository.usuario;

import com.info.app.projectapp.persistance.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
}
