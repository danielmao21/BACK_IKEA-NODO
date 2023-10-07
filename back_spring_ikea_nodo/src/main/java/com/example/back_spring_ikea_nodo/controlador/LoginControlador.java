package com.example.back_spring_ikea_nodo.controlador;

import com.example.back_spring_ikea_nodo.dto.LoginDTO;
import com.example.back_spring_ikea_nodo.modelo.RolXusuario;
import com.example.back_spring_ikea_nodo.modelo.Usuario;
import com.example.back_spring_ikea_nodo.servicio.UsuarioServicioImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class LoginControlador {

    private final UsuarioServicioImpl usuarioServicioImpl;

    public LoginControlador(UsuarioServicioImpl usuarioServicioImpl) {
        this.usuarioServicioImpl = usuarioServicioImpl;
    }

    @PostMapping("")
    public ResponseEntity<RolXusuario> autenticarUsuario(@RequestBody LoginDTO loginDTO) {
        RolXusuario usuarioAutenticado = usuarioServicioImpl.autenticarUsuario(loginDTO);

        if (usuarioAutenticado != null) {
            return ResponseEntity.ok(usuarioAutenticado );
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
