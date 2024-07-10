package com.examen.examen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examen.examen.models.Automovil;
import com.examen.examen.services.AutomovilService;

import java.util.List;

@RestController
@RequestMapping("/automoviles")
public class AutomovilController {

    @Autowired
    private AutomovilService automovilService;

    @GetMapping
    public List<Automovil> getAllAutomoviles() {
        return automovilService.getAllAutomoviles();
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<Automovil> getAutomovilByMatricula(@PathVariable String matricula) {
        Automovil automovil = automovilService.getAutomovilByMatricula(matricula);
        return ResponseEntity.ok(automovil);
    }

    @PostMapping
    public ResponseEntity<Automovil> createAutomovil(@RequestBody Automovil automovil) {
        Automovil createdAutomovil = automovilService.createAutomovil(automovil);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAutomovil);
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<Automovil> updateAutomovil(@PathVariable String matricula, @RequestBody Automovil automovil) {
        Automovil updatedAutomovil = automovilService.updateAutomovil(matricula, automovil);
        return ResponseEntity.ok(updatedAutomovil);
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<Void> deleteAutomovil(@PathVariable String matricula) {
        automovilService.deleteAutomovil(matricula);
        return ResponseEntity.noContent().build();
    }
}
