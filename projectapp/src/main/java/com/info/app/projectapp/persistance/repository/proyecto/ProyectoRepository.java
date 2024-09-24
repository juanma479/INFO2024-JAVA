package com.info.app.projectapp.persistance.repository.proyecto;

import com.info.app.projectapp.persistance.domain.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProyectoRepository extends JpaRepository<Proyecto, UUID> {
}
