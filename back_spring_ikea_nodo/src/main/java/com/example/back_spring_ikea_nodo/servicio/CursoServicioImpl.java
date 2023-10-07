package com.example.back_spring_ikea_nodo.servicio;

import com.example.back_spring_ikea_nodo.dto.CursoRegistroDTO;
import com.example.back_spring_ikea_nodo.modelo.Curso;
import com.example.back_spring_ikea_nodo.repositorio.CursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CursoServicioImpl  {
    Date fechaActual = new Date();

    private CursoRepositorio cursoRepositorio;

    @Autowired
    public CursoServicioImpl(CursoRepositorio cursoRepositorio) {
        this.cursoRepositorio = cursoRepositorio;
    }

    public Curso guardarCurso(CursoRegistroDTO registroCursoRegistroDTO) {
        Curso curso = Curso.builder()
                .id_curso(registroCursoRegistroDTO.getId_curso())
                .nombreCurso(registroCursoRegistroDTO.getNombreCurso())
                .horas(registroCursoRegistroDTO.getHoras())
                .fechaRegistro(fechaActual)
                .build();
        return cursoRepositorio.save(curso);
    }

}
