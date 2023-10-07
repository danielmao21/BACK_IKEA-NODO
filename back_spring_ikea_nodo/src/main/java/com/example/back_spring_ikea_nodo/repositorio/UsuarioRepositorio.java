package com.example.back_spring_ikea_nodo.repositorio;

import com.example.back_spring_ikea_nodo.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    Usuario findByCorreo(String correo);



}

