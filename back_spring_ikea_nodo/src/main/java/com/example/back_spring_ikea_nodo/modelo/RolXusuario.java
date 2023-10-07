package com.example.back_spring_ikea_nodo.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rolxusuario")
public class RolXusuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rol_usuario;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;
}
