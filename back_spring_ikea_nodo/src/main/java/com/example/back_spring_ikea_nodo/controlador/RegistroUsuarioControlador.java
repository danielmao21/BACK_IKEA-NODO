package com.example.back_spring_ikea_nodo.controlador;
import com.example.back_spring_ikea_nodo.dto.LoginDTO;
import com.example.back_spring_ikea_nodo.dto.UsuarioRegistroDTO;
import com.example.back_spring_ikea_nodo.modelo.Usuario;
import com.example.back_spring_ikea_nodo.servicio.UsuarioServicioImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registro")
@CrossOrigin(origins = "*")
public class RegistroUsuarioControlador {

    private final UsuarioServicioImpl usuarioServicioImpl;

    public RegistroUsuarioControlador(UsuarioServicioImpl usuarioServicioImpl) {
        this.usuarioServicioImpl = usuarioServicioImpl;
    }

    @PostMapping("")
    public ResponseEntity<Usuario> registrarCuenta(@RequestBody UsuarioRegistroDTO registroDTO) {
        return new ResponseEntity<>(usuarioServicioImpl.guardar(registroDTO), HttpStatus.CREATED);
    }

}