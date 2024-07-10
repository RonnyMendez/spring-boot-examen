package com.examen.examen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examen.examen.models.Automovil;
import com.examen.examen.repositories.AutomovilRepository;

import java.util.List;

@Service
@Transactional
public class AutomovilService {

    @Autowired
    private AutomovilRepository automovilRepository;

    public List<Automovil> getAllAutomoviles() {
        return automovilRepository.findAll();
    }

    public Automovil getAutomovilByMatricula(String matricula) {
        return automovilRepository.findById(matricula)
                .orElseThrow(() -> new IllegalArgumentException("Automóvil no encontrado con matrícula: " + matricula));
    }

    public Automovil createAutomovil(Automovil automovil) {
        return automovilRepository.save(automovil);
    }

    public Automovil updateAutomovil(String matricula, Automovil automovil) {
        if (!automovilRepository.existsById(matricula)) {
            throw new IllegalArgumentException("Automóvil no encontrado con matrícula: " + matricula);
        }
        automovil.setMatricula(matricula); // asegura que el automóvil tenga la matrícula correcta para la actualización
        return automovilRepository.save(automovil);
    }

    public void deleteAutomovil(String matricula) {
        automovilRepository.deleteById(matricula);
    }
}
