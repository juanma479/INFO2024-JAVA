package com.info.app.projectapp.persistance.repository.tarea;

import com.info.app.projectapp.persistance.domain.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TareaRepository extends JpaRepository<Tarea, UUID> {
    List<Tarea> findByProyectoId(UUID uuid);
}
