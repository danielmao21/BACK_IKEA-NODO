package com.example.back_spring_ikea_nodo.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRegistroDTO {
    private Long idUsuario;
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String contrasena;

}
