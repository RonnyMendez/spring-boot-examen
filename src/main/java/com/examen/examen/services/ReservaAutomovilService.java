package com.examen.examen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examen.examen.models.ReservaAutomovil;
import com.examen.examen.repositories.ReservaAutomovilRepository;

import java.util.List;

@Service
@Transactional
public class ReservaAutomovilService {

    @Autowired
    private ReservaAutomovilRepository reservaAutomovilRepository;

    public List<ReservaAutomovil> getAllReservaAutomoviles() {
        return reservaAutomovilRepository.findAll();
    }

    public List<ReservaAutomovil> getReservaAutomovilesByReserva(Long idReserva) {
        return reservaAutomovilRepository.findByReservaIdReserva(idReserva);
    }

    public List<ReservaAutomovil> getReservaAutomovilesByAutomovil(String matricula) {
        return reservaAutomovilRepository.findByAutomovilMatricula(matricula);
    }

    public ReservaAutomovil createReservaAutomovil(ReservaAutomovil reservaAutomovil) {
        return reservaAutomovilRepository.save(reservaAutomovil);
    }

    public void deleteReservaAutomovil(Long idReserva, String matricula) {
        reservaAutomovilRepository.deleteByReservaIdReservaAndAutomovilMatricula(idReserva, matricula);
    }
}


