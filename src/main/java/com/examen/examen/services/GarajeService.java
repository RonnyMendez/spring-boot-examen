package com.examen.examen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examen.examen.models.Garaje;
import com.examen.examen.repositories.GarajeRepository;

import java.util.List;

@Service
@Transactional
public class GarajeService {

    @Autowired
    private GarajeRepository garajeRepository;

    public List<Garaje> getAllGarajes() {
        return garajeRepository.findAll();
    }

    public Garaje getGarajeById(Long idGaraje) {
        return garajeRepository.findById(idGaraje)
                .orElseThrow(() -> new IllegalArgumentException("Garaje no encontrado con ID: " + idGaraje));
    }

    public Garaje createGaraje(Garaje garaje) {
        return garajeRepository.save(garaje);
    }

    public Garaje updateGaraje(Long idGaraje, Garaje garaje) {
        if (!garajeRepository.existsById(idGaraje)) {
            throw new IllegalArgumentException("Garaje no encontrado con ID: " + idGaraje);
        }
        garaje.setIdGaraje(idGaraje); // asegura que el garaje tenga el ID correcto para la actualización
        return garajeRepository.save(garaje);
    }

    public void deleteGaraje(Long idGaraje) {
        garajeRepository.deleteById(idGaraje);
    }
}
