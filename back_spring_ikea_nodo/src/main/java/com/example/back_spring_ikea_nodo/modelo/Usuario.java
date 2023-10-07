package com.example.back_spring_ikea_nodo.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name= "nombre")
    private String nombre;

    @Column(name= "apellido")
    private String apellido;

    @Column(name= "correo")
    private String correo;

    @Column(name= "contrasena")
    private String contrasena;

}
