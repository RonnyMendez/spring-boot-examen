package com.examen.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.examen.models.Garaje;

@Repository
public interface GarajeRepository extends JpaRepository<Garaje, Long> {
    // Puedes añadir métodos de consulta adicionales si es necesario
}
