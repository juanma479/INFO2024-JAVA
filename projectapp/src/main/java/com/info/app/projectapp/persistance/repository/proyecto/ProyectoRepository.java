package com.info.app.projectapp.persistance.repository.proyecto;

import com.info.app.projectapp.persistance.domain.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ProyectoRepository extends JpaRepository<Proyecto, UUID> {

    List<Proyecto> findByNombreLike(String nombre);

    boolean existsByColaboradores_Id(UUID colaboradorId);

    boolean existsByLider_Id(UUID liderid);

    List<Proyecto> findByFechaInicioGreaterThanEqualAndFechaFinLessThan(LocalDate fehaInicio, LocalDate fechaFin);


}
