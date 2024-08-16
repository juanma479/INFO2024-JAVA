package escenario2.dominio;

import escenario2.enumeration.ComplejidadEnum;
import escenario2.enumeration.ModalidadEnum;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CursoTeorico extends Curso{
    private ModalidadEnum modalidad;


    //Constructor
    public CursoTeorico(UUID id, String nombre, Integer cantHoras, ComplejidadEnum complejidad,
            Map<Long, Estudiante> estudiantes, List<Examen> examenes, ModalidadEnum modalidad) {
        super(id, nombre, cantHoras, complejidad, estudiantes, examenes);
        this.modalidad = modalidad;
    }

    
    //Getters y Setters
    public ModalidadEnum getModalidad() {
        return modalidad;
    }
    public void setModalidad(ModalidadEnum modalidad) {
        this.modalidad = modalidad;
    }

    

}
