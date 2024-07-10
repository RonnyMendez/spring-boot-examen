package com.examen.examen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examen.examen.models.Garaje;
import com.examen.examen.services.GarajeService;

import java.util.List;

@RestController
@RequestMapping("/garajes")
public class GarajeController {

    @Autowired
    private GarajeService garajeService;

    @GetMapping
    public List<Garaje> getAllGarajes() {
        return garajeService.getAllGarajes();
    }

    @GetMapping("/{idGaraje}")
    public ResponseEntity<Garaje> getGarajeById(@PathVariable Long idGaraje) {
        Garaje garaje = garajeService.getGarajeById(idGaraje);
        return ResponseEntity.ok(garaje);
    }

    @PostMapping
    public ResponseEntity<Garaje> createGaraje(@RequestBody Garaje garaje) {
        Garaje createdGaraje = garajeService.createGaraje(garaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGaraje);
    }

    @PutMapping("/{idGaraje}")
    public ResponseEntity<Garaje> updateGaraje(@PathVariable Long idGaraje, @RequestBody Garaje garaje) {
        Garaje updatedGaraje = garajeService.updateGaraje(idGaraje, garaje);
        return ResponseEntity.ok(updatedGaraje);
    }

    @DeleteMapping("/{idGaraje}")
    public ResponseEntity<Void> deleteGaraje(@PathVariable Long idGaraje) {
        garajeService.deleteGaraje(idGaraje);
        return ResponseEntity.noContent().build();
    }
}
