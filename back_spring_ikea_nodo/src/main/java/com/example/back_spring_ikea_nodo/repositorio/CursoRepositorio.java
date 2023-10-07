package com.example.back_spring_ikea_nodo.repositorio;

import com.example.back_spring_ikea_nodo.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepositorio extends JpaRepository<Curso, Long> {

}
