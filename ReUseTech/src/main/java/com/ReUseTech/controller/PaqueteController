package com.ReUseTech.controller;

import com.ReUseTech.model.Paquete;
import com.ReUseTech.service.PaqueteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paquetes")
public class PaqueteController {

    @Autowired
    private PaqueteService paqueteService;

    // Obtener todos los paquetes
    @GetMapping
    public List<Paquete> obtenerTodosLosPaquetes() {
        return paqueteService.obtenerTodosLosPaquetes();
    }

    // Obtener un paquete por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Paquete> obtenerPaquetePorId(@PathVariable Long id) {
        Paquete paquete = paqueteService.obtenerPaquetePorId(id);
        return ResponseEntity.ok(paquete);
    }

    // Actualizar el estado y localización de un paquete
    @PutMapping("/{id}")
    public ResponseEntity<Paquete> actualizarPaquete(@PathVariable Long id, @RequestBody Paquete paquete) {
        Paquete paqueteExistente = paqueteService.obtenerPaquetePorId(id);
        paqueteExistente.setEstadoActual(paquete.getEstadoActual());
        paqueteExistente.setLocalizacion(paquete.getLocalizacion());
        Paquete actualizado = paqueteService.actualizarPaquete(paqueteExistente);
        return ResponseEntity.ok(actualizado);
    }

    // Crear un nuevo paquete
    @PostMapping
    public ResponseEntity<Paquete> crearPaquete(@RequestBody Paquete paquete) {
        Paquete nuevoPaquete = paqueteService.guardarPaquete(paquete);
        return ResponseEntity.ok(nuevoPaquete);
    }
}
