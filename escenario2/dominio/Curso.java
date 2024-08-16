package escenario2.dominio;

import escenario2.enumeration.ComplejidadEnum;
import java.util.*;

public class Curso {
    private UUID id;
    private String nombre;
    private Integer cantHoras;
    private ComplejidadEnum complejidad;

    private Map<Long,Estudiante> estudiantes = new TreeMap<>();
    private List<Examen> examenes = new ArrayList<>();


    //Constructor
    public Curso(UUID id, String nombre, Integer cantHoras, ComplejidadEnum complejidad,
            Map<Long, Estudiante> estudiantes, List<Examen> examenes) {
        this.id = id;
        this.nombre = nombre;
        this.cantHoras = cantHoras;
        this.complejidad = complejidad;
        this.estudiantes = estudiantes;
        this.examenes = examenes;
    }
    

    //Getters y Setters
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getCantHoras() {
        return cantHoras;
    }
    public void setCantHoras(Integer cantHoras) {
        this.cantHoras = cantHoras;
    }
    public ComplejidadEnum getComplejidad() {
        return complejidad;
    }
    public void setComplejidad(ComplejidadEnum complejidad) {
        this.complejidad = complejidad;
    }
    public Map<Long, Estudiante> getEstudiantes() {
        return estudiantes;
    }
    public void setEstudiantes(Map<Long, Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
    public List<Examen> getExamenes() {
        return examenes;
    }
    public void setExamenes(List<Examen> examenes) {
        this.examenes = examenes;
    }
    

    

}