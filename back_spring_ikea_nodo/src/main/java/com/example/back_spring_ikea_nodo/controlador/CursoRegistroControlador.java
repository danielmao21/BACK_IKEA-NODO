package com.example.back_spring_ikea_nodo.controlador;

import com.example.back_spring_ikea_nodo.modelo.Curso;
import com.example.back_spring_ikea_nodo.servicio.CursoServicioImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.back_spring_ikea_nodo.dto.CursoRegistroDTO;


@RestController
@RequestMapping("/CursoRegistro")
@CrossOrigin(origins = "*")
public class CursoRegistroControlador {

    private CursoServicioImpl cursoServicioImpl;

    public CursoRegistroControlador(CursoServicioImpl cursoServicioImpl) {
        this.cursoServicioImpl = cursoServicioImpl;
    }

    @PostMapping("")
    public ResponseEntity<Curso> registroCurso(@RequestBody CursoRegistroDTO cursoRegistroDTO) {
        return new ResponseEntity<>(cursoServicioImpl.guardarCurso(cursoRegistroDTO), HttpStatus.CREATED);
    }


}
