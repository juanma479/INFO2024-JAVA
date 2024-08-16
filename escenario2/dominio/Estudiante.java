package escenario2.dominio;

import java.time.LocalDate;
import java.util.*;

public class Estudiante {
    private String nombre;
    private LocalDate fechaNac;
    private Long dni;

    private List<Curso> cursos = new ArrayList<>();


    //Constructor
    public Estudiante(String nombre, LocalDate fechaNac, Long dni, List<Curso> cursos) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.dni = dni;
        this.cursos = cursos;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }



}
