package com.example.back_spring_ikea_nodo.controlador;

import com.example.back_spring_ikea_nodo.modelo.Curso;
import com.example.back_spring_ikea_nodo.modelo.Matricula;
import com.example.back_spring_ikea_nodo.modelo.Usuario;
import com.example.back_spring_ikea_nodo.repositorio.CursoRepositorio;
import com.example.back_spring_ikea_nodo.repositorio.UsuarioRepositorio;
import com.example.back_spring_ikea_nodo.servicio.MatriculaServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.back_spring_ikea_nodo.dto.MatriculaRegistroDTO;
import org.webjars.NotFoundException;

@RestController
@RequestMapping("/matricula")
@CrossOrigin(origins = "*")
public class MatriculaControlador {

    private MatriculaServicio matriculaServicio;
    private CursoRepositorio cursoRepositorio;
    private UsuarioRepositorio usuarioRepositorio;


    public MatriculaControlador(MatriculaServicio matriculaServicio, CursoRepositorio cursoRepositorio, UsuarioRepositorio usuarioRepositorio) {
        this.matriculaServicio = matriculaServicio;
        this.cursoRepositorio = cursoRepositorio;
        this.usuarioRepositorio = usuarioRepositorio;

    }

    @PostMapping("")
    public ResponseEntity<Matricula> matricularse(@RequestBody MatriculaRegistroDTO matriculaRegistroDTO) {

        Curso curso = cursoRepositorio.findById(matriculaRegistroDTO.getId_curso()).orElseThrow(() -> new NotFoundException("Curso no encontrado"));
        Usuario usuario = usuarioRepositorio.findById(matriculaRegistroDTO.getId_usuario()).orElseThrow(() -> new NotFoundException("Usuario no encontrado"));

        Matricula matricula = matriculaServicio.matricularse(curso, usuario);
        return ResponseEntity.ok(matricula);
    }
}
