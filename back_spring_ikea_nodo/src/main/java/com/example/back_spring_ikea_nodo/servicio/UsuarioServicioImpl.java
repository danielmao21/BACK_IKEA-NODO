package com.example.back_spring_ikea_nodo.servicio;

import com.example.back_spring_ikea_nodo.dto.LoginDTO;
import com.example.back_spring_ikea_nodo.dto.UsuarioRegistroDTO;
import com.example.back_spring_ikea_nodo.modelo.Rol;
import com.example.back_spring_ikea_nodo.modelo.RolXusuario;
import com.example.back_spring_ikea_nodo.modelo.Usuario;
import com.example.back_spring_ikea_nodo.repositorio.RolRepositorio;
import com.example.back_spring_ikea_nodo.repositorio.RolXusuarioRepositorio;
import com.example.back_spring_ikea_nodo.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicioImpl {

    private UsuarioRepositorio usuarioRepositorio;
    private RolXusuarioRepositorio rolXusuarioRepositorio;

    private RolRepositorio rolRepositorio;


    @Autowired
    public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio, RolXusuarioRepositorio rolXusuarioRepositorio, RolRepositorio rolRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.rolXusuarioRepositorio = rolXusuarioRepositorio;
        this.rolRepositorio = rolRepositorio;
    }

    public Usuario guardar(UsuarioRegistroDTO registroDTO) {
        Usuario usuario = Usuario.builder()
                .correo(registroDTO.getCorreoElectronico())
                .nombre(registroDTO.getNombre())
                .apellido(registroDTO.getApellido())
                .contrasena(registroDTO.getContrasena())
                .build();
        usuarioRepositorio.save(usuario);

        RolXusuario rolXusuario = new RolXusuario();

        Rol rol = rolRepositorio.findById(2L).orElseThrow(() -> new RuntimeException("El rol con ID 2 no existe"));

        rolXusuario.setUsuario(usuario);
        rolXusuario.setRol(rol);

        rolXusuarioRepositorio.save(rolXusuario);
        return usuario;
    }

    public RolXusuario autenticarUsuario(LoginDTO loginDTO) {

        Usuario usuario = usuarioRepositorio.findByCorreo(loginDTO.getCorreoElectronico());

        if (usuario.getCorreo().equals(loginDTO.getCorreoElectronico()) && usuario.getContrasena().equals(loginDTO.getContrasena())) {

            RolXusuario rolXusuario = rolXusuarioRepositorio.findByUsuario_IdUsuario(usuario.getIdUsuario());

            return rolXusuario;
        } else {
            throw new IllegalArgumentException("Credenciales inválidas");
        }
    }

    public String eliminarUsuario(Long idUsuario) {
        Optional<Usuario> usuarioOptional = usuarioRepositorio.findById(idUsuario);

        if (usuarioOptional.isPresent()) {

             rolXusuarioRepositorio.deleteById(idUsuario);

            usuarioRepositorio.deleteById(idUsuario);


            return ("Usuario " + usuarioOptional.get().getNombre() + " eliminado correctamente");
        } else {

            return ("Usuario no encontrado con ID: " + idUsuario);
        }
    }

    public List<Usuario> obtenerUsuario(){

        return (List<Usuario>) usuarioRepositorio.findAll();
    }


}
