package com.examen.examen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examen.examen.models.ReservaAutomovil;
import com.examen.examen.services.ReservaAutomovilService;

import java.util.List;

@RestController
@RequestMapping("/api/reserva-automoviles")
public class ReservaAutomovilController {

    @Autowired
    private ReservaAutomovilService reservaAutomovilService;

    @GetMapping
    public ResponseEntity<List<ReservaAutomovil>> getAllReservaAutomoviles() {
        List<ReservaAutomovil> reservasAutomoviles = reservaAutomovilService.getAllReservaAutomoviles();
        return ResponseEntity.ok(reservasAutomoviles);
    }

    @GetMapping("/reserva/{idReserva}")
    public ResponseEntity<List<ReservaAutomovil>> getReservaAutomovilesByReserva(@PathVariable Long idReserva) {
        List<ReservaAutomovil> reservasAutomoviles = reservaAutomovilService.getReservaAutomovilesByReserva(idReserva);
        return ResponseEntity.ok(reservasAutomoviles);
    }

    @GetMapping("/automovil/{matricula}")
    public ResponseEntity<List<ReservaAutomovil>> getReservaAutomovilesByAutomovil(@PathVariable String matricula) {
        List<ReservaAutomovil> reservasAutomoviles = reservaAutomovilService.getReservaAutomovilesByAutomovil(matricula);
        return ResponseEntity.ok(reservasAutomoviles);
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