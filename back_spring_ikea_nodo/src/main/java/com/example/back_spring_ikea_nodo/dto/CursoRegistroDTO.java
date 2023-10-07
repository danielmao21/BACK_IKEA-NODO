package com.example.back_spring_ikea_nodo.dto;

import lombok. *;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CursoRegistroDTO {

    private Long id_curso;
    private String nombreCurso;
    private Long horas;
    private Date fechaRegistro;
}
