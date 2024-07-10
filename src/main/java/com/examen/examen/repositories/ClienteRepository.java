package com.examen.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.examen.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Puedes añadir métodos de consulta adicionales si es necesario
}
