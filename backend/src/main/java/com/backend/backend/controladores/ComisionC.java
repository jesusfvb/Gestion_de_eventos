package com.backend.backend.controladores;

import java.util.LinkedList;
import java.util.List;

import com.backend.backend.auxiliares.respuestas.ModComision;
import com.backend.backend.auxiliares.solicitudes.NuevaComision;
import com.backend.backend.repositorios.entidades.Comision;
import com.backend.backend.servicios.ComisionS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/comision")
public class ComisionC {

    @Autowired
    private ComisionS servicios;

    @GetMapping
    public ResponseEntity<List<ModComision>> listar() {
        return respuesta();
    }

    @PutMapping
    public ResponseEntity<List<ModComision>> salvar(@RequestBody(required = true) NuevaComision solicitud) {

        servicios.salvar(solicitud.getIdEvento(), solicitud.getNombre(), solicitud.getLineaTematica(),
                solicitud.getIdsComiteOrganizador());
        return respuesta();
    }

    private ResponseEntity<List<ModComision>> respuesta() {
        List<ModComision> salida = new LinkedList<>();
        for (Comision comision : servicios.listar()) {
            salida.add(comision.convertir());
        }
        return ResponseEntity.ok(salida);
    }
}
