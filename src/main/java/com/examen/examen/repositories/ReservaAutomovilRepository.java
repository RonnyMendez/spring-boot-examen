package com.examen.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.examen.models.ReservaAutomovil;

import java.util.List;

@Repository
public interface ReservaAutomovilRepository extends JpaRepository<ReservaAutomovil, Long> {

    List<ReservaAutomovil> findByReservaIdReserva(Long idReserva);

    List<ReservaAutomovil> findByAutomovilMatricula(String matricula);

    void deleteByReservaIdReservaAndAutomovilMatricula(Long idReserva, String matricula);
}
