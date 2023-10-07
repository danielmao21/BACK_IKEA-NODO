package com.example.back_spring_ikea_nodo.repositorio;

import com.example.back_spring_ikea_nodo.modelo.Curso;
import com.example.back_spring_ikea_nodo.modelo.Matricula;
import com.example.back_spring_ikea_nodo.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepositorio extends JpaRepository<Matricula, Long> {
    boolean existsByCursoAndUsuario(Curso curso, Usuario usuario);
}
