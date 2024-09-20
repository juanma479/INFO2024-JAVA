package com.info.app.projectapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String nombre;


    @Column(nullable = false)
    private LocalDate fechaInicio;


    @Column(nullable = false)
    private LocalDate fechaFin;


//    private Usuario lider;
//
////   private List<Usuario> colaboradores;
////
////   private List<Tarea> tareas;


}
