package com.example.back_spring_ikea_nodo.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_curso;

    @Column(name = "horas_duracion")
    private Long horas;

    @Column(name = "nombre_curso")
    private String nombreCurso;

    @CreatedDate
    @Column(name = "fecha_registro")
    private Date fechaRegistro;
}
