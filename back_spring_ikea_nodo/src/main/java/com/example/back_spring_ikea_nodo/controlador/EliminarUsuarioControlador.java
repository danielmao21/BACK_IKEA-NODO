package com.example.back_spring_ikea_nodo.controlador;

import com.example.back_spring_ikea_nodo.servicio.UsuarioServicioImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/eliminarUsuario")
@CrossOrigin(origins = "*")
public class EliminarUsuarioControlador {

    private final UsuarioServicioImpl usuarioServicioImpl;

    public  EliminarUsuarioControlador(UsuarioServicioImpl usuarioServicioImpl){
        this.usuarioServicioImpl = usuarioServicioImpl;
    }

    @DeleteMapping("/delete/{id}")
    public String EliminarUsuario (@PathVariable Long id){
    if (id!= null){
           String respon =  usuarioServicioImpl.eliminarUsuario(id);

           return  respon + HttpStatus.CREATED;
    }
        return "usuario eliminado Correctamente";
    }
}
