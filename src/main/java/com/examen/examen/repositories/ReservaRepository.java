package com.examen.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.examen.models.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    // Puedes añadir métodos de consulta adicionales si es necesario
}
