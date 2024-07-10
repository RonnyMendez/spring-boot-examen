package com.examen.examen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examen.examen.models.Reserva;
import com.examen.examen.repositories.ReservaRepository;

import java.util.List;

@Service
@Transactional
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    public Reserva getReservaById(Long idReserva) {
        return reservaRepository.findById(idReserva)
                .orElseThrow(() -> new IllegalArgumentException("Reserva no encontrada con ID: " + idReserva));
    }

    public Reserva createReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Reserva updateReserva(Long idReserva, Reserva reserva) {
        if (!reservaRepository.existsById(idReserva)) {
            throw new IllegalArgumentException("Reserva no encontrada con ID: " + idReserva);
        }
        reserva.setIdReserva(idReserva); // asegura que la reserva tenga el ID correcto para la actualización
        return reservaRepository.save(reserva);
    }

    public void deleteReserva(Long idReserva) {
        reservaRepository.deleteById(idReserva);
    }
}
