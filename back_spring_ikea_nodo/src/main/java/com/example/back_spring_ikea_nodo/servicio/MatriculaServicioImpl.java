package com.example.back_spring_ikea_nodo.servicio;

import com.example.back_spring_ikea_nodo.dto.MatriculaRegistroDTO;
import com.example.back_spring_ikea_nodo.modelo.Curso;
import com.example.back_spring_ikea_nodo.modelo.Matricula;
import com.example.back_spring_ikea_nodo.modelo.Usuario;
import com.example.back_spring_ikea_nodo.repositorio.CursoRepositorio;
import com.example.back_spring_ikea_nodo.repositorio.MatriculaRepositorio;
import com.example.back_spring_ikea_nodo.repositorio.UsuarioRepositorio;
import org.springframework.stereotype.Service;

@Service
public class MatriculaServicioImpl implements MatriculaServicio {

    private MatriculaRepositorio matriculaRepositorio;
    private final CursoRepositorio cursoRepositorio;
    private final UsuarioRepositorio usuarioRepositorio;

    public MatriculaServicioImpl(MatriculaRepositorio matriculaRepositorio, CursoRepositorio cursoRepositorio, UsuarioRepositorio usuarioRepositorio) {
        this.matriculaRepositorio = matriculaRepositorio;
        this.cursoRepositorio = cursoRepositorio;
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public Matricula matricularse(Curso curso, Usuario usuario) {


        if (matriculaRepositorio.existsByCursoAndUsuario(curso, usuario)) {
            throw new RuntimeException("El usuario ya está matriculado en el curso");
        }
        Matricula matricula = new Matricula(curso, usuario);

        matriculaRepositorio.save(matricula);

        return matricula;
    }
}
