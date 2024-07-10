package com.examen.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.examen.models.Automovil;

@Repository
public interface AutomovilRepository extends JpaRepository<Automovil, String> {
    // Puedes añadir métodos de consulta adicionales si es necesario
}
