package com.info.app.projectapp.presentation.controller.tarea;

import com.info.app.projectapp.persistance.domain.enums.EstadoTareaEnum;
import com.info.app.projectapp.presentation.dto.tarea.TareaCreatedDto;
import com.info.app.projectapp.presentation.dto.tarea.TareaDto;
import com.info.app.projectapp.service.tarea.TareaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class TareaController {

    private TareaService tareaService;

    @PostMapping("api/v1/tarea")
    public ResponseEntity<?> createTarea(@RequestBody TareaDto tareaDto) {

        Optional<TareaCreatedDto> tareaCreatedDto = tareaService.createTarea(tareaDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(tareaCreatedDto.get());
    }


    @PutMapping("api/v1/tarea/{idTarea}/estado")
    public ResponseEntity<String> updateEstadoTarea(@PathVariable ("idTarea") UUID idTarea,
                                            @RequestBody EstadoTareaEnum estadoTareaEnum) {

        boolean isUpdated = tareaService.updateEstadoTarea(idTarea, estadoTareaEnum);

        if (isUpdated) {
            return ResponseEntity.ok("Estado de la tarea de ID "+idTarea+" se ha actualizado.");
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al actualizar el estado de la tarea.");
    }


    @DeleteMapping("api/v1/tarea/{idTarea}")
    public ResponseEntity<?> deleteTarea(@PathVariable("idTarea") UUID idTarea) {

        boolean isDeleted = tareaService.deleteTarea(idTarea);

        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
