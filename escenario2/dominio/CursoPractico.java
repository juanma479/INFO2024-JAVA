package escenario2.dominio;

import escenario2.enumeration.ComplejidadEnum;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CursoPractico extends Curso {
    private List<Recurso> recursos = new ArrayList();

    //Constructor
    public CursoPractico(UUID id, String nombre, Integer cantHoras, ComplejidadEnum complejidad,
            Map<Long, Estudiante> estudiantes, List<Examen> examenes, List<Recurso> recursos) {
        super(id, nombre, cantHoras, complejidad, estudiantes, examenes);
        this.recursos = recursos;
    }

    //Getters y Setters
    public List<Recurso> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<Recurso> recursos) {
        this.recursos = recursos;
    }

    

}
