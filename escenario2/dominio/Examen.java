package escenario2.dominio;

import java.time.LocalDateTime;

public class Examen {
    private Curso curso;
    private Estudiante estudiante;
    private Double calificacion;
    private String descripcion;
    private LocalDateTime fechaExamen;

    //Constructor
    public Examen(Curso curso, Estudiante estudiante, Double calificacion, String descripcion,
            LocalDateTime fechaExamen) {
        this.curso = curso;
        this.estudiante = estudiante;
        this.calificacion = calificacion;
        this.descripcion = descripcion;
        this.fechaExamen = fechaExamen;
    }

    


    public Examen(Curso curso, Estudiante estudiante) {
        this.curso = curso;
        this.estudiante = estudiante;
        // Nota, descripción y fechaExamen se inicializan a valores predeterminados
        this.calificacion = null;
        this.descripcion = "";
        this.fechaExamen = null;
    }




    //Getters y Setters
    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    public Estudiante getEstudiante() {
        return estudiante;
    }
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    public Double getCalificacion() {
        return calificacion;
    }
    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public LocalDateTime getFechaExamen() {
        return fechaExamen;
    }
    public void setFechaExamen(LocalDateTime fechaExamen) {
        this.fechaExamen = fechaExamen;
    }

    

}
