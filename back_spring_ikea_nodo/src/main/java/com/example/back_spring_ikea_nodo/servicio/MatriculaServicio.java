package com.example.back_spring_ikea_nodo.servicio;

import com.example.back_spring_ikea_nodo.modelo.Curso;
import com.example.back_spring_ikea_nodo.modelo.Matricula;
import com.example.back_spring_ikea_nodo.modelo.Usuario;

public interface MatriculaServicio {
    Matricula matricularse(Curso curso, Usuario usuario);
}
