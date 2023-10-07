package com.example.back_spring_ikea_nodo.controlador;

import com.example.back_spring_ikea_nodo.modelo.Usuario;
import com.example.back_spring_ikea_nodo.servicio.UsuarioServicioImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.back_spring_ikea_nodo.servicio.UsuarioServicioImpl;
import java.util.List;


@RestController
@RequestMapping("/obtenerUsuarios")
@CrossOrigin(origins = "*")
public class ObtenerUsuariosControlador {

    private final UsuarioServicioImpl usuarioServicioImpl;
    ObtenerUsuariosControlador(UsuarioServicioImpl usuarioServicioImpl){
        this.usuarioServicioImpl = usuarioServicioImpl;
    }
    @GetMapping
    public List<Usuario> obtenerTodosLosUsuarios() {

        return usuarioServicioImpl.obtenerUsuario();
    }
}
