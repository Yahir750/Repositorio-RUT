
package com.ReUseTech.com.ReUseTech.service.paquete;

import com.ReUseTech.com.ReUseTech.model.Paquete;
import com.ReUseTech.com.ReUseTech.repository.PaqueteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaqueteService {

    @Autowired
    private PaqueteRepository paqueteRepository;

    // Obtener todos los paquetes disponibles
    public List<Paquete> obtenerTodosLosPaquetes() {
        return paqueteRepository.findAll();
    }

    // Buscar un paquete por su ID
    public Paquete obtenerPaquetePorId(Long idPaquete) {
        return paqueteRepository.findById(idPaquete)
                .orElseThrow(() -> new RuntimeException("Paquete no encontrado"));
    }

    // Actualizar el estado y localización del paquete
    public Paquete actualizarPaquete(Paquete paquete) {
        paquete.setFechaActualizacion(LocalDateTime.now());
        return paqueteRepository.save(paquete);
    }

    // Guardar un nuevo paquete
    public Paquete guardarPaquete(Paquete paquete) {
        return paqueteRepository.save(paquete);
    }
}
