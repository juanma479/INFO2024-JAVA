package com.info.app.projectapp.service.proyecto;


import com.info.app.projectapp.persistance.domain.Proyecto;

import java.util.UUID;

public interface ProyectoService {

    Proyecto getProyectoById(UUID id);
}
