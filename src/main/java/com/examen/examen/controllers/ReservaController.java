package com.examen.examen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examen.examen.models.Reserva;
import com.examen.examen.services.ReservaService;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public List<Reserva> getAllReservas() {
        return reservaService.getAllReservas();
    }

    @GetMapping("/{idReserva}")
    public ResponseEntity<Reserva> getReservaById(@PathVariable Long idReserva) {
        Reserva reserva = reservaService.getReservaById(idReserva);
        return ResponseEntity.ok(reserva);
    }

    @PostMapping
    public ResponseEntity<Reserva> createReserva(@RequestBody Reserva reserva) {
        Reserva createdReserva = reservaService.createReserva(reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReserva);
    }

    @PutMapping("/{idReserva}")
    public ResponseEntity<Reserva> updateReserva(@PathVariable Long idReserva, @RequestBody Reserva reserva) {
        Reserva updatedReserva = reservaService.updateReserva(idReserva, reserva);
        return ResponseEntity.ok(updatedReserva);
    }

    @DeleteMapping("/{idReserva}")
    public ResponseEntity<Void> deleteReserva(@PathVariable Long idReserva) {
        reservaService.deleteReserva(idReserva);
        return ResponseEntity.noContent().build();
    }
}
