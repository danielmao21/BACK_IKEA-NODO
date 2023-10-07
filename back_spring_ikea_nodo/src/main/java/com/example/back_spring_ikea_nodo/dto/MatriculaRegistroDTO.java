package com.example.back_spring_ikea_nodo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaRegistroDTO{

    private Long id_usuario;
    private Long id_curso;

}
