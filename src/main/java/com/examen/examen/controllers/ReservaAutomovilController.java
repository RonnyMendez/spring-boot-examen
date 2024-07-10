package com.examen.examen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examen.examen.models.ReservaAutomovil;
import com.examen.examen.services.ReservaAutomovilService;

import java.util.List;

@RestController
@RequestMapping("/reserva-automoviles")
public class ReservaAutomovilController {

    @Autowired
    private ReservaAutomovilService reservaAutomovilService;

    @GetMapping
    public List<ReservaAutomovil> getAllReservaAutomoviles() {
        return reservaAutomovilService.getAllReservaAutomoviles();
    }

    @GetMapping("/reserva/{idReserva}")
    public List<ReservaAutomovil> getReservaAutomovilesByReserva(@PathVariable Long idReserva) {
        return reservaAutomovilService.getReservaAutomovilesByReserva(idReserva);
    }

    @GetMapping("/automovil/{matricula}")
    public List<ReservaAutomovil> getReservaAutomovilesByAutomovil(@PathVariable String matricula) {
        return reservaAutomovilService.getReservaAutomovilesByAutomovil(matricula);
    }

    @PostMapping
    public ResponseEntity<ReservaAutomovil> createReservaAutomovil(@RequestBody ReservaAutomovil reservaAutomovil) {
        ReservaAutomovil createdReservaAutomovil = reservaAutomovilService.createReservaAutomovil(reservaAutomovil);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReservaAutomovil);
    }

    @DeleteMapping("/reserva/{idReserva}/automovil/{matricula}")
    public ResponseEntity<Void> deleteReservaAutomovil(@PathVariable Long idReserva, @PathVariable String matricula) {
        reservaAutomovilService.deleteReservaAutomovil(idReserva, matricula);
        return ResponseEntity.noContent().build();
    }
}
