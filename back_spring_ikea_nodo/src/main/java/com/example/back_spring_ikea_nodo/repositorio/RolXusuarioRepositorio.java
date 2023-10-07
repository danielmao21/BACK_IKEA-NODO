package com.example.back_spring_ikea_nodo.repositorio;

import com.example.back_spring_ikea_nodo.modelo.RolXusuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RolXusuarioRepositorio extends JpaRepository<RolXusuario, Long> {
    RolXusuario findByUsuario_IdUsuario(Long idUsuario);


}
